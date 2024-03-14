package step3;

public class CarName {

    private final String name;

    public CarName(String name) {
        if (nameValidation(name)) {
            throw new IllegalArgumentException("이름은 널이거나 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean nameValidation(String name) {
        return name == null || name.length() > 5;
    }

    public String getName() {
        return this.name;
    }
}
