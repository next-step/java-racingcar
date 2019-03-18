package racingcar;

import racingcar.utils.Constant;

public class RacingCar {
    private String name;
    private int coordinate;

    public RacingCar(String name) {
        this.name = name;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }

    public int move(int randomValue) {
        if (randomValue >= Constant.NUMBER_4)
            return ++this.coordinate;
        return this.coordinate;
    }

    public boolean isMaxCoordinate(int maxCoordinate) {
        return maxCoordinate == coordinate;
    }

    public int findMaxCoordinate(int checkCoordinate) {
        if (coordinate > checkCoordinate)
            return coordinate;
        return checkCoordinate;
    }
}

