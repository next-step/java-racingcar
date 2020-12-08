package step3;

public class Name {
    private String name;
    private final int MAX_LENGTH = 5;

    public Name(String name) {
        checkNameValue(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameValue(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("1자 이상 5자 이하의 이름이 필요합니다");
        }
    }
}
