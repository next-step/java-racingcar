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

    public int getScore() {
        return score.getScore();
    }

    void go(RandomState randomState) {
        if (randomState.isMovable()) {
            score.add();
        }
    }

    public boolean isSameScore(int score) {
        return this.score.isSameScore(score);
    }


}
