package com.zzm.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengzm
 * @date 2019/7/10 10:05
 * @description 性别枚举类
 */
public enum SexEnum {

    MAN("1", "男"), WOMAN("2", "女"), UNKNOW("-1","未知");

    private String key;
    private String value;
    private static Map<String, SexEnum> sexEnumMap = new HashMap<>();

    static {
        for (SexEnum sexEnum : SexEnum.values()) {
            sexEnumMap.put(sexEnum.getKey(), sexEnum);
        }
    }

    /**
     * 私有化构造函数
     *
     * @param key
     * @param value
     */
    private SexEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     *
     * @Title: getSexEnumByKey
     * @Description: 依据key获取枚举
     * @param key
     * @return
     */
    public static SexEnum getSexEnumByKey(String key) {
        return sexEnumMap.get(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
