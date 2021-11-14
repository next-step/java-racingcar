package racinggame.domain;

public class Name {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ERROR_CAR_NAME_MAX_LENGTH = "[ERROR] 자동차의 이름은 5글자 이하여야 합니다.";

    private final String name;

    public Name(String name) throws Exception {
        validate(name);
        this.name = name;
    }

    private void validate(String name) throws Exception {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new Exception(ERROR_CAR_NAME_MAX_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
