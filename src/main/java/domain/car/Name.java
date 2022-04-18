package domain.car;

public class Name {
    public static final int MAX_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다");
        }
        this.name = name;
    }

    public String value() {
        return this.name;
    }

}
