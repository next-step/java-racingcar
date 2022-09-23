package controller.impl;

import controller.InputView;
import model.GameParam;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleInputView implements InputView {

    public static final String CAR_NUMBER_ASK_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_NUMBER_ASK_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String RUN_RESULT_MSG = "실행 결과";
    public static final String RUN_FAIL_USER_MSG = "자동차 대수 , 시도할 회수는 숫자값이여만 합니다.";

    @Override
    public GameParam getInputFromUser() {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println(CAR_NUMBER_ASK_QUESTION);
            int carNumber = sc.nextInt();
            System.out.println(TRY_NUMBER_ASK_QUESTION);
            int tryNumber = sc.nextInt();
            System.out.println(RUN_RESULT_MSG);
            return new GameParam(carNumber,tryNumber);
        }catch (InputMismatchException e){
            System.out.println(RUN_FAIL_USER_MSG);
            throw new IllegalArgumentException(e);
        }
    }
}