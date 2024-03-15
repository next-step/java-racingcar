package step3;

public class CarName {

    private final String name;

    public CarName(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void nameValidation(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("이름은 널이거나 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
