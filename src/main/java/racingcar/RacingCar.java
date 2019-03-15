package racingcar;

public class RacingCar {
    private int coord;
    private String name;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public int getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public int move(int randomValue) {
        if (randomValue >= Constant.NUMBER_4)
            return ++this.coord;
        return this.coord;
    }

    public int createRandom() {
        return (int) (Math.random() * Constant.RANDOM_NUM) + Constant.NUMBER_1;
    }
}

