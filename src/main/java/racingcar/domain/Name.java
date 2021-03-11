package racingcar.domain;

public class Name {

    private static final int MAX_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (isValueInValidation(name)) {
            throw new IllegalArgumentException("차이름은 5글자 이하만 사용할 수 있습니다.");
        }

        this.name = name;
    }

    public boolean isValueInValidation(String name) {
        return name.length() > MAX_LENGTH;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
