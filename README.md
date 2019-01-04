# simple-bean-copier
一个效率较高的类复制工具，优于springframework的BeanUtils.copyProperties();

多次执行内部的test对比，发现其性能约是BeanUtils.copyProperties()的十倍左右。
~~~
  SimpleBeanCopier多次耗时：3398537
  BeanUtils多次耗时：34181072
~~~
