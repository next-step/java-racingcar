package racingcargame;

import java.lang.reflect.Field;

public class TestUtil {

    public static <T> T getPrivateField(Object from, String name) {
        try {
            Field field = from.getClass().getDeclaredField(name);
            field.setAccessible(true);

            return (T) field.get(from);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("잘못된 결과입니다.");
    }

}
