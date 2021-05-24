package racingcar.domain;

public class Car {
    private RacingRandom racingRandom = new RacingRandom();
    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        if (racingRandom.isMove()) {
            this.location++;
        }
    }

    public boolean compareWinnerScore(int winnerScore){
        return location == winnerScore;
    }

    public String getName() {
        return name;
    }

    public int getLocationInfo() {
        return location;
    }

}
