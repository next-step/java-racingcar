package study.step3;

public class Rule {

    private final int numberOfCars;
    private final int movingTimes;

    public Rule(int racingLines, int movingTimes) {
        validate(racingLines, movingTimes);
        this.numberOfCars = racingLines;
        this.movingTimes = movingTimes;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMovingTimes() {
        return movingTimes;
    }

    private static void validate(int racingLines, int movingTimes) {
        if (!isValidRacingLines(racingLines)) {
            throw new RacingException("RuleValidationError: 자동차 대수는 2대 이상이여야 합니다.");
        }
        if (!isValidMovingTimes(movingTimes)) {
            throw new RacingException("RuleValidationError: 시도 회수는 최소 1회 이상이어야 합니다.");
        }
    }

    private static boolean isValidRacingLines(int racingLines) {
        return racingLines >= 2;
    }

    private static boolean isValidMovingTimes(int movingTimes) {
        return movingTimes >= 1;
    }


}
