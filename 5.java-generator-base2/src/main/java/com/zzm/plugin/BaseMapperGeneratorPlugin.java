package com.zzm.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 让Mapper自动继承一个基类
 *
 * @author zhengzm
 * @Date 2019/11/22
 **/
public class BaseMapperGeneratorPlugin extends PluginAdapter{

    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String extMapperClassStr = String.format("Ext%sMapper",
            getLastName(introspectedTable.getBaseRecordType()));
        // 添加基类
        FullyQualifiedJavaType extExtendsClass = new FullyQualifiedJavaType(extMapperClassStr);

        String baseClassStr = String.format("BaseMapper<%s, %s, %s>",
                introspectedTable.getBaseRecordType(),
                introspectedTable.getExampleType(),
                // 假如有多主键的话，请自行关闭这个插件，这个类暂不支持多主键
                introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType());

        // 添加基类
        FullyQualifiedJavaType baseInterface = new FullyQualifiedJavaType(baseClassStr);

        // 添加import
        FullyQualifiedJavaType extClassImpo = new FullyQualifiedJavaType("com.zzm.mapper.extmapper.Ext"
            +getLastName(introspectedTable.getBaseRecordType())+"Mapper");
        FullyQualifiedJavaType baseMapperImpo = new FullyQualifiedJavaType("com.zzm.base.BaseMapper");
        FullyQualifiedJavaType mapperImpo = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");

        interfaze.addSuperInterface(extExtendsClass);
        interfaze.addSuperInterface(baseInterface);

        interfaze.addImportedType(baseMapperImpo);
        interfaze.addImportedType(extClassImpo);
        interfaze.addImportedType(mapperImpo);

        interfaze.addJavaDocLine("@Mapper");

        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();
        return true;
    }

    private String getLastName(String path){
      return path.substring(path.lastIndexOf(".")+1);
    }


}
