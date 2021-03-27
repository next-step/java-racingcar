package step03Refactor;

public class Name {
    private final String name;

    public Name(String name) {
        checkValidate(name);
        this.name = name;
    }

    private void checkValidate(String name) {
        if (name.length() <= 0) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이상 초과할 수 없습니다");
        }
    }

    public String getName() {
        return name;
    }

}
