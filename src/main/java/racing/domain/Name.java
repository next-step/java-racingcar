package racing.domain;

public class Name {

    private static final Integer NAME_LEN_MAX = 5;

    private String value;

    public Name(String name) {
        validateName(name);
        this.value = name;
    }

    private static void validateName(String name) {
        if (name.length() > NAME_LEN_MAX) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

}
