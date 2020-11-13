package study.racing.view;

import study.racing.domain.RacingErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_TRY_MESSAGE = "시도 횟수를 입력하세요.";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_NAME_DELIMITER = ",";

    public static final int MAX_CAR_NAME_LENGTH = 5;

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static int getTryCount(){
        System.out.println(INPUT_TRY_MESSAGE);
        int tryCount = scanner.nextInt();
        validateTryCount(tryCount);
        return tryCount;
    }

    public static String[] getCarsName(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return splitCarNames(scanner.next());
    }

    private static String[] splitCarNames(String carNames) {
        String [] carNameArray = carNames.split(CAR_NAME_DELIMITER);
        return carNameArray;
    }

    public static void validateTryCount(int tryCnt) {
        if(tryCnt == 0){
            throw new IllegalArgumentException(RacingErrorMessage.ZERO_TRY_COUNT.getErrorMessage());
        }
    }

    public static void validateCarCount(int carCnt) {
        if(carCnt == 0){
            throw new IllegalArgumentException(RacingErrorMessage.ZERO_CAR_COUNT.getErrorMessage());
        }
    }
}
