package step3.domain;

public class CarName {
    private String value;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.value = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getValue() {
        return value;
    }
}
