package racinggame.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하여야 합니다.");
        }
        this.name = name;
    }
}
