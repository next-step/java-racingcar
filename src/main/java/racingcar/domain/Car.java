package racingcar.domain;

public class Car {
    private Score score;
    private CarName name;

    Car(String name) {
        this.name = new CarName(name);
        score = new Score();
    }

    public String getName() {
        return name.getName();
    }

    public Score getScore() {
        return score;
    }

    void go(MoveState moveState) {
        if (moveState.isMovable()) {
            score.add();
        }
    }

    boolean isSameNumber(int number) {
        return this.score.equals(new Score(number));
    }
}
