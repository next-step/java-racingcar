package RacingGame.model;

public class Name {
    private static final int CAR_LENGTH_EXCEED = 5;
    private static final String CARNAME_LENGTH_EXCEED = String.format("차량의 이름은 %d 글자가 넘어갈 수 없습니다", CAR_LENGTH_EXCEED);
    private final String name;

    public Name(String name) {
        if (name.length() > CAR_LENGTH_EXCEED) {
            throw new IllegalArgumentException(CARNAME_LENGTH_EXCEED);
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
