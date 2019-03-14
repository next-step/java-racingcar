package racingcar;

public class RacingCar {
    static final int NUMBER_1 = 1;
    static final int NUMBER_4 = 4;
    static final int RANDOM_NUM = 10;
    private int coord;

    public int move(int randomValue) {
        if (randomValue >= NUMBER_4)
            return ++this.coord;
        return this.coord;
    }

    public int createRandom() {
        return (int) (Math.random() * RANDOM_NUM) + NUMBER_1;
    }
}

