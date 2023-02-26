package work;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class work03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> file = Class.forName("java.io.File");
       // Constructor<?>[] declaredConstructors = file.getDeclaredConstructors();//获取所有构造器

//        for (Constructor<?> declaredConstructor : declaredConstructors) {
//            System.out.println("File构造器=" + declaredConstructor);
//        }
        Constructor<?> declaredConstructor = file.getDeclaredConstructor(String.class);
        String filePath = "d:\\mytemp\\hello.txt";
        Object o = declaredConstructor.newInstance(filePath);//创建file对象
//
        System.out.println(o);
        Method createNewFile = file.getMethod("createNewFile");//获取方法对象
        createNewFile.invoke(o);

    }
}
