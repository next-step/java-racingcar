package racingGame.model.car;

import racingGame.service.RacingGameService;

public class TryNo {

    private static final int MINIMUM_MOVE_COUNT = 1;

    private static final String MOVE_COUNT_ERROR_MESSAGE = "최소 1회 이상은 입력해주세요!";

    private int round;

    private final RacingGameService gameService;

    public TryNo(int tryNo, RacingGameService gameService) {
        validateMoveCount(tryNo);
        this.round = tryNo;
        this.gameService = gameService;
    }

    public CarMovement tryForRounds(int carCount) {
        Cars cars = Cars.createCars(carCount);
        CarMovement ret = new CarMovement();

        for (int i = 0; i < this.round; i++) {
            Cars car = gameService.moveAllCarByOneStep(cars);
            ret.addOneStepProgress(car);
        }

        return ret;
    }

    public int getTryNo() {
        return this.round;
    }

    private void validateMoveCount(int tryNo) {
        if (tryNo < MINIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException(MOVE_COUNT_ERROR_MESSAGE);
        }
    }
}
