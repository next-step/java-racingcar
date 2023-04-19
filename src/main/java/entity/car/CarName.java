package entity.car;

public class CarName {

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validateName(name);
        return new CarName(name);
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
