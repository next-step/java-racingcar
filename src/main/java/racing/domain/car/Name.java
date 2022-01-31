package racing.domain.car;

public class Name {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    final String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public Name(Name name) {
        this(name.getName());
    }

    private static void checkNameLength(final String name) {
        if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 이름의 길이는 " + CAR_NAME_MIN_LENGTH + " ~ " + CAR_NAME_MAX_LENGTH
                    + " 글자 까지만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
