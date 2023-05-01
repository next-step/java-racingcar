package entity.car;

import java.util.List;
import java.util.RandomAccess;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private static void validateName(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException("차 이름이 null값 이거나 빈 값일 수는 없습니다.");
        }
    }

    private static boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }
}
