import java.lang.reflect.*;

public class Invoker {
    public static void main(String[] args) throws Exception {
        MyClass obj = new MyClass();
        Class<?> clazz = MyClass.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat annotation = method.getAnnotation(Repeat.class);
                int times = annotation.times();
                if (!Modifier.isPublic(method.getModifiers())) {
                    method.setAccessible(true);
                    for (int i = 0; i < times; i++) {
                        if (method.getName().equals("privateMethod1")) {
                            method.invoke(obj, "Сообщение");
                        } else if (method.getName().equals("privateMethod2")) {
                            method.invoke(obj, 52);
                        } else {
                            method.invoke(obj); // для методов без параметров
                        }
                    }
                }
            }
        }
    }
}