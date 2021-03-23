package step3.util;

import step3.exception.CarRaceCheckInputException;

public class InputValidator {

    public static void validate(int carCount, int racingCount){
        if(carCount < 1){
            throw new CarRaceCheckInputException("자동차 수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(carCount)));
        }

        if(racingCount < 1){
            throw new CarRaceCheckInputException("시도할 회수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(carCount)));
        }
    }
}
