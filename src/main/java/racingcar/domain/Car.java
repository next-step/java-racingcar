package racingcar.domain;

public class Car {
    private static final int CAR_LENGTH = 5;
    private String name;
    private int location;

    public Car(String name) {
        invalidedName(name);

        this.name = name;
        this.location = 0;
    }

    public void invalidedName(String name) {
        if (name.length() > CAR_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.location++;
        }
    }

    public boolean compareWinnerScore(int winnerScore) {
        return this.location == winnerScore;
    }

    public String getName() {
        return this.name;
    }

    public int getLocationInfo() {
        return this.location;
    }

}
