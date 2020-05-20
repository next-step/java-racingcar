package study.step3;

import java.util.Objects;

public class RacingGame {
    private final static String DELIMETER = ",";
    private final static String SPACE_CHARATER = "";
    private final static int MINIMUM_CAR_NUMBER = 1;
    private final static String ILLEGALARGUMENT_CAR_NAMES_MASSEAGE = "자동차 명을 입력해야 합니다.";
    private final static String ILLEGALARGUMENT_TRY_NUMBER_MASSEAGE = "0 보다는 큰 값을 입력해야 합니다.";

    private final String carNames;
    private final int time;

    public RacingGame(String carNames, int time) {
        valitateCarNames(carNames);
        valitateTryTime(time);
        this.carNames = carNames;
        this.time = time;
    }

    private void valitateTryTime(int nextInt) {
        if (nextInt < MINIMUM_CAR_NUMBER){
            throw new IllegalArgumentException(ILLEGALARGUMENT_TRY_NUMBER_MASSEAGE);
        }
    }

    private void valitateCarNames(String carNames) {
        if (Objects.isNull(carNames) || SPACE_CHARATER.equals(carNames.trim())){
            throw new IllegalArgumentException(ILLEGALARGUMENT_CAR_NAMES_MASSEAGE);
        }
    }

    public String [] getCarEntries() {
        return carNames.split(DELIMETER);
    }

    public int getTryTime(){
        return time;
    }
}
