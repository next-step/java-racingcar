package racingcar.domain;

public class Name {

    private String names;

    private static final int MAX_NAME_LENGTH = 5;

    public Name(final String names) {
        validate(names);
        this.names = names;
    }

    private void validate(String names) {
        if(names == null || names.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다.");
        }

        if (names.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getNames() {
        return names;
    }
}
