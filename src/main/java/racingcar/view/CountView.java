package racingcar.view;

public class CountView implements InputView{

    private final int carCount;
    private final int raceCount;

    public CountView(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;
    }

    @Override
    public Integer readCar() {
        return carCount;
    }

    @Override
    public Integer readRace() {
        return raceCount;
    }
}
