package step4.domain.primitivewrapper;

public class Name {

    private static final int CONDITION_OF_NAME = 5;

    private String name;

    public Name() {
    }

    public Name (String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isNone(name)) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }

        if (isOverFiveChar(name)) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isOverFiveChar(String name) {
        return name.length() > CONDITION_OF_NAME;
    }

    private boolean isNone(String name) {
        return name == null || name.isEmpty() || name.isBlank();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
