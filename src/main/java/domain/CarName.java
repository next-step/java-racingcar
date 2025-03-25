package domain;

public class CarName {
    private final String name;

    private final static int MAX_CAR_NAME = 5;

    public CarName(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("name은 null이거나 빈 값일 수 없습니다.");
        }

        if (name.length() > MAX_CAR_NAME) {
            throw new RuntimeException("name은 5자를 초과할 수 없습니다. name :" + name);
        }
    }

    public String getCarName() {
        return this.name;
    }
}
