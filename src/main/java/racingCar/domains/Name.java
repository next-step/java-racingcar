package racingCar.domains;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
