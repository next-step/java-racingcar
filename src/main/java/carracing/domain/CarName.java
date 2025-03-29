package carracing.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name.trim();
    }

    public String getValue() {
        return name;
    }
}
