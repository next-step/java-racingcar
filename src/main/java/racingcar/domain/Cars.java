package racingcar.domain;

public class Cars {
    private RacingRandom racingRandom = new RacingRandom();

    private static final int CAR_LENGTH = 5;
    private String name;
    private int location;

    public Cars(String name, int location) {
        invalidedName(name);

        this.name = name;
        this.location = location;
    }

    public Cars(String name) {
        invalidedName(name);

        this.name = name;
        this.location = 0;
    }

    public void invalidedName(String name) {
        if (name.length() > CAR_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }

    public void move() {
        if (racingRandom.isMove()) {
            this.location++;
        }
    }

    public boolean compareWinnerScore(int winnerScore) {
        return location == winnerScore;
    }

    public String getName() {
        return name;
    }

    public int getLocationInfo() {
        return location;
    }

}
