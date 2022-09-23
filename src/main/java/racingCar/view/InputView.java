package racingCar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final String ASK_HOW_MANY_CARS_MESSAGE = "자동 대수는 몇 대 인가요?";
    private final String ASK_HOW_MANY_TIMES_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String NOT_INTGER_TYPE ="정수 타입이 아닙니다.";
    private final String PLEASE_ENTER_AGAIN ="다시 입력 해주세요.";

    public int askHowMayCars(){
        System.out.println(ASK_HOW_MANY_CARS_MESSAGE);
        return scanInt();
    }
    public int askHowManyTimes(){
        System.out.println(ASK_HOW_MANY_TIMES_MESSAGE);
        return scanInt();
    }

    private int scanInt(){
        Scanner scanner = new Scanner(System.in);
        try{
            int number = scanner.nextInt();
            return number;
        }catch (InputMismatchException e){
            System.out.println(NOT_INTGER_TYPE);
            System.out.println(PLEASE_ENTER_AGAIN);
            scanInt();
        }
        return 0;
    }
}
