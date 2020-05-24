package racingCar.dto;

import java.util.Arrays;

public class RacingGameInfo {
    private final String[] carNames;
    private final int time;

    public RacingGameInfo(String[] carNames,int time) {
        validateNames(carNames);
        validateRange(carNames.length, time);
        this.carNames = carNames;
        this.time = time;
    }

    private void validateNames(String[] carNames) {
        if (carNames.length != trimNameSize(carNames)) {
            throw new IllegalArgumentException("빈 문자열이 있습니다.");
        }
    }

    private int trimNameSize(String[] carNames) {
        return (int) Arrays.stream(carNames).map(String::trim).filter(name -> !name.isEmpty()).count();
    }

    private void validateRange(int carCount, int time) {
        if (carCount <= 0 || time <= 0) {
            throw new IllegalArgumentException("0이하는 경기를 진행할 수가 없습니다.");
        }
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTime() {
        return time;
    }
}
