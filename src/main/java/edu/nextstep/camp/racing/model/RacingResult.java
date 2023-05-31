package edu.nextstep.camp.racing.model;

public class RacingResult {

    private static final String RESULT_NOTICE_KOR = "레이싱 결과";
    private static final String MOVING_BAR = "-";
    private static final char NEW_LINE = '\n';
    private final Car[] cars;
    private final int movingCnt;
    private StringBuilder resultStringBuilder;

    public RacingResult(Car[] cars, int movingCnt) {
        this.cars = cars;
        this.movingCnt = movingCnt;

        resultStringBuilder = new StringBuilder();

        resultStringBuilder
                .append(NEW_LINE)
                .append(RESULT_NOTICE_KOR)
                .append(NEW_LINE);
    }

    @Override
    public String toString() {
        for (int movingIdx = 0; movingIdx < movingCnt; movingIdx++) {
            appendMovingBar(movingIdx);
        }

        return resultStringBuilder.toString();
    }

    private void appendMovingBar(int movingIdx){
        for (Car car : cars) {
            resultStringBuilder.append(MOVING_BAR.repeat(car.distance(movingIdx)));
            resultStringBuilder.append(NEW_LINE);
        }
        resultStringBuilder.append(NEW_LINE);
    }

}
