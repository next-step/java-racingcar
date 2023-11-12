package racing.model;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;

    private Name() {
    }

    public static String getName(String name) throws IllegalAccessException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalAccessException("이름은 최대 5글자 입니다.");
        }
        return name;
    }
}
