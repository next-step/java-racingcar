package racing.domain;

public class CarName {
    private static int MAX_LENGTH = 5;
    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("차 이름은 empty 또는 공백일 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름이 5자보다 깁니다.");
        }
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
