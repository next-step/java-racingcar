package car.domain;

public class Name {

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() >= 5) throw new IllegalArgumentException("자동차 이름은 5자 미만만 가능 합니다. name = " + name);
    }

    public String printName() {
        return name;
    }

    @Override
    public String toString() {
        return this.printName();
    }
}
