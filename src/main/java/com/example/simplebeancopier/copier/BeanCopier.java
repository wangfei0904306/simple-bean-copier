package com.example.simplebeancopier.copier;


import java.util.function.Function;

/**
 * @ClassName BeanCopier
 * @Description cglib bean copy
 *
 * @author huangshengju
 * @date 2018年07月11日
 * @version 1.0
 */
public class BeanCopier<F,T> implements Function<F,T>, com.google.common.base.Function<F, T> {

	private net.sf.cglib.beans.BeanCopier beanCopier;

	protected net.sf.cglib.beans.BeanCopier getBeanCopier() {
		return beanCopier;
	}

	protected void init(){
		this.beanCopier = net.sf.cglib.beans.BeanCopier.create(sourceClass, targetClass, true);
	}

	private Class<T> targetClass;

	private Class<F> sourceClass;

	private BeanCopier<T,F> reverse;

	public BeanCopier<T, F> reverse() {
		return reverse;
	}

	public Function<T, F> getReverse() {
		if (this.reverse != null) {
			return this.reverse;
		}
		BeanCopier<T, F> reverse = this.reverse;
		synchronized (this) {
			if (reverse == null) {
				reverse = new BeanCopier<T, F>();
				reverse.setSourceClass(this.getTargetClass());
				reverse.setTargetClass(this.getSourceClass());
				reverse.init();
			}
		}
		return reverse;
	}

	public void setReverse(BeanCopier<T, F> reverse) {
		this.reverse = reverse;
	}

	protected Class<T> getTargetClass() {
		return targetClass;
	}

	protected Class<F> getSourceClass() {
		return sourceClass;
	}

	public void setTargetClass(Class<T> targetClass) {
		this.targetClass = targetClass;
	}

	public void setSourceClass(Class<F> sourceClass) {
		this.sourceClass = sourceClass;
	}

	public T afterCopy(F source,T target){
		return target;
	}

	public T copy(F input) {
		try {
			T o = targetClass.newInstance();
			DataTypeConverter converter = new DataTypeConverter();
			beanCopier.copy(input, o, converter);
			return afterCopy(input, o);
		} catch (Exception e) {
			throw new RuntimeException("create object fail, class:" + targetClass.getName() + " ", e);
		}
	}

	@Override
	public T apply(F input) {
		return copy(input);
	}

	@Override
	public <V> Function<V, T> compose(Function<? super V, ? extends F> before) {
		return null;
	}
}
