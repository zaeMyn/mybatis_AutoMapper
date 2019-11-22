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
        String baseClassStr = String.format("Ext%sMapper",
            getLastName(introspectedTable.getBaseRecordType()));
        // 添加基类
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(baseClassStr);

        // 添加import
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.zzm.mapper.extmapper.Ext"
            +getLastName(introspectedTable.getBaseRecordType())+"Mapper");
        FullyQualifiedJavaType mapperImpl = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");

        interfaze.addSuperInterface(fqjt);
        interfaze.addImportedType(imp);
        interfaze.addImportedType(mapperImpl);

        interfaze.addJavaDocLine("@Mapper");

        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();
        return true;
    }

    private String getLastName(String path){
      return path.substring(path.lastIndexOf(".")+1);
    }


}
