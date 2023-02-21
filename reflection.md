```java
        //反射
		Method method1 = aClass.getMethod(method);//方法对象调用类的对象
        method1.invoke(o);
        Field name = aClass.getField("age");//获取属性
        System.out.println(name.get(o));
        Constructor constructor = aClass.getConstructor();//获取构造器,()里面可以写参数
        System.out.println(constructor);
        Constructor constructor1 = aClass.getConstructor(String.class);//
        System.out.println(constructor1);
```

