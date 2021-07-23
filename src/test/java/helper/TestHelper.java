package helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestHelper {
    public static Object invokePrivateMethod(Object targetObject, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = targetObject.getClass().getDeclaredMethod(methodName);

        privateMethod.setAccessible(true);

        return privateMethod.invoke(targetObject);
    }
}
