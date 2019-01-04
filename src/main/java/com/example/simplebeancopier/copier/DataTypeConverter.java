package com.example.simplebeancopier.copier;


import net.sf.cglib.core.Converter;

/**
 * <br>类 名: DataTypeConverter
 * <br>描 述: cglib处理数据类型问题
 */
public class DataTypeConverter implements Converter {

    @SuppressWarnings("rawtypes")
    @Override
    public Object convert(Object value, Class target, Object context) {

        return value;
    }

}
