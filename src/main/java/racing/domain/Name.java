package racing.domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String value) {
        if (value == null || value.isEmpty() || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 비어 있을 수 없으며, 5자를 초과할 수 없습니다.");
        }
        this.name = value;
    }

    public String getName() {
        return name;
    }


}
