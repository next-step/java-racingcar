package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_HOW_MANY_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_HOW_MANY_TIMES_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String NOT_INTEGER_TYPE_MESSAGE = "정수 타입이 아닙니다.";
    private static final String PLEASE_ENTER_AGAIN_MESSAGE = "다시 입력 해주세요.";

    private InputView (){

    }

    public static int askHowManyCars(){
        System.out.println(ASK_HOW_MANY_CARS_MESSAGE);
        return scanInputNumber();
    }

    public static int askHowManyTimes(){
        System.out.println(ASK_HOW_MANY_TIMES_MESSAGE);
        return scanInputNumber();
    }

    private static int scanInputNumber(){
        Scanner scanner = new Scanner(System.in);

        try{
            int number = scanner.nextInt();
            if (number > 0){
                return number;
            }
        }catch (Exception e){
            System.out.println(NOT_INTEGER_TYPE_MESSAGE);
            System.out.println(PLEASE_ENTER_AGAIN_MESSAGE);
        }
        return scanInputNumber();
    }
}
