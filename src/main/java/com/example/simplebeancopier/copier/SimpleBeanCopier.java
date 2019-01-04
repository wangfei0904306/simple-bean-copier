package com.example.simplebeancopier.copier;

/**
 * <br>类 名: SimpleBeanCopier
 * <br>描 述: 
 * <p/>
 * <br>作 者: huangshengju
 * <br>创 建: 2017年11月29日
 * <br>版 本: 1.0
 * <br>
 * <br>历 史: (版本) 作者 时间 注释
 */
public class SimpleBeanCopier<F,T> extends BeanCopier<F,T> {


	public SimpleBeanCopier(Class<F> sourceClass, Class<T> targetClass){
		setSourceClass(sourceClass);
		setTargetClass(targetClass);
		init();
	}

}
