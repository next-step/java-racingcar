package racingcar;

public class RacingCar {
    private String name;
    private int coordinate;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar(int coordinate) {
        this.coordinate = coordinate;
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

    public int createRandom() {
        return (int) (Math.random() * Constant.RANDOM_NUM) + Constant.NUMBER_1;
    }

    public boolean isMaxCoordinate(int maxCoordinate) {
        return maxCoordinate >= coordinate;
    }

    public int findMaxCoordinate(int checkCoordinate){
        if (coordinate > checkCoordinate)
            return coordinate;
        return  checkCoordinate;
    }
}

