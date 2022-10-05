package racing.domain.car;

public class Name {

    private final String nameValue;

    public Name(String nameValue) {

        if (nameValue == null || nameValue.isBlank()) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다");
        }

        if (nameValue.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다");
        }

        this.nameValue = nameValue;
    }

    public String getNameValue() {
        return nameValue;
    }
}
