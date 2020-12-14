package racingcar.domain;

public class RacingGameWithCarName extends RacingGame {

    private final CarNames carNames;     // 자동차 이름 목록

    public RacingGameWithCarName(CarNames carNames, int moveCount) {
        super(carNames.size(), moveCount);
        this.carNames = carNames;
    }

    protected RacingCar createRacingCar(int index) {
        return new RacingCar(carNames.getCarName(index));
    }

}
