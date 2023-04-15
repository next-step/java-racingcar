package car;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다.");
        }
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
