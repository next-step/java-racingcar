package study.racing.view;

import study.racing.CarRacing;
import study.racing.RacingErrorMessage;

import java.util.Scanner;

public class InputView {

    private static String INPUT_CAR_MESSAGE = "자동차 대수를 입력하세요.";
    private static String INPUT_TRY_MESSAGE = "시도 횟수를 입력하세요.";

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}
    public static int getCarCount(){
        System.out.println(INPUT_CAR_MESSAGE);
        int carCnt = scanner.nextInt();
        validateCarCount(carCnt);
        return scanner.nextInt();
    }

    public static int getTryCount(){
        System.out.println(INPUT_TRY_MESSAGE);
        int tryCnt = scanner.nextInt();
        validateTryCount(tryCnt);
        return scanner.nextInt();
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
