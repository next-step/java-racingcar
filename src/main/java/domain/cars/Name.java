package domain.cars;

public class Name {
    private static int NAME_SIZE_LIMIT = 5;
    private String name;

    public Name(String name) {
        isValid(name);
        this.name = name;
    }

    public Name() {
        this.name = "";
    }

    private void isValid(String name) {
        if (name.length() > NAME_SIZE_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
