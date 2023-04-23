package step5;

public class RacingGame {
    private static final int moveSize = 1;
    private int tryCount;
    private Cars cars;


    public RacingGame(RacingGameInputData inputData) {
        this.tryCount = inputData.getTryCount();
        this.cars = Cars.of(inputData.getCarNames());
    }

    public ResultDto race(MovingStrategy movingStrategy) {
        ResultDto resultDto = new ResultDto();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(movingStrategy, moveSize);
            resultDto.logScore(cars);
        }
        resultDto.setWinners(cars.getWinners());
        return resultDto;
    }


}
