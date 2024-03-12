package racingcar;

public class Name {

    private final static int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new NameLengthExceededException();
        }
    }
}
