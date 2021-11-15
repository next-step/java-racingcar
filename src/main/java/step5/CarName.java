package step5;

public class CarName {

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotNull(name);
        validateMaxLength(name);
    }

    private void validateNotNull(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new InvalidCarNameException("자동차의 이름은 비어있을 수 없습니다");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > 5) {
            throw new InvalidCarNameException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != CarName.class) {
            return false;
        }
        CarName other = (CarName) o;
        return this.name.equals(other.name);
    }
}
