package racingcar.model;

class Car {
    private int score;

    Car() {
        score = 0;
    }

    void go() {
        score++;
    }

    int getScore() {
        return this.score;
    }
}
