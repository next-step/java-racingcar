package racingcar;

public class Name {

    private final String name;
    private static final int CAR_NANE_MINIMUM_LENGTH = 1;
    private static final int CAR_NANE_MAXIMUM_LENGTH = 5;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public Name(Name nameToBeCopied) {
        this.name = nameToBeCopied.name;
    }

    private void validateName(String name) {
        if (name.length() < CAR_NANE_MINIMUM_LENGTH || name.length() > CAR_NANE_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 "+CAR_NANE_MINIMUM_LENGTH+"글자 이상, "+CAR_NANE_MAXIMUM_LENGTH+"글자 이하입니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
