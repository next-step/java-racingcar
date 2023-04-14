package racingcar.domain;

public class Name {

    private String[] names;

    private static final String NAME_DELIMITER = ",";

    public Name(final String names) {
        validate(names);
        this.names = names.split(NAME_DELIMITER);
    }

    private void validate(String names) {
        if(names == null || names.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다.");
        }
    }

    public String[] getNames() {
        return names;
    }
}
