package racingcar_tdd.domain;

public class Name {
    private static final int MAXINUM_NAME_LENGTH = 5;
    private final String value;

    public Name(String value) {
        if (value.length() > MAXINUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의이름은 5글자를 넘을 수 없습니다.");
        }
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
