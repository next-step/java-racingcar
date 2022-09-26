package racingcar;

public class RacingGame {
    private final int carNums;
    private final int tryNums;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingGame(int carNums, int tryNums) {
        this.carNums = carNums;
        this.tryNums = tryNums;
    }

    public RacingRecord racingStart() {
        RoundCars roundCars = new RoundCars(carNums);
        for (int round = 0; round < tryNums; round++) {
            racingRecord.createNewRoundRecord();
            roundCars.moveCars(racingRecord);
        }
        return racingRecord;
    }
}
