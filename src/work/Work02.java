package work;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Work02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("work.PrivateTest");//这种方式也可以
        //Class<PrivateTest> privateTestClass = PrivateTest.class;//这种方式也可以
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"hello");
        Object getName = aClass.getMethod("getName").invoke(o);
        System.out.println(getName);
    }
}

class PrivateTest{
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

}