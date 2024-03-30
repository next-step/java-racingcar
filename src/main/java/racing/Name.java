package racing;

public class Name {

    public static final int MAX_NAME = 5;
    private final String name;

    public Name(String name) {
        if (name.trim().length() > MAX_NAME) {
            throw new IllegalStateException("자동차 이름은 " + MAX_NAME + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
