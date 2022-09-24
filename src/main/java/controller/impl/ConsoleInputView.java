package controller.impl;

import controller.InputView;
import model.GameParam;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleInputView implements InputView {

    @Override
    public GameParam getInputFromUser() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(CAR_NUMBER_ASK_QUESTION);
            int carNumber = sc.nextInt();
            System.out.println(TRY_NUMBER_ASK_QUESTION);
            int tryNumber = sc.nextInt();
            System.out.print(RUN_RESULT_MSG);
            return GameParam.paramWithCarNumAndTryNum(carNumber, tryNumber);
        } catch (InputMismatchException e) {
            System.out.println(RUN_FAIL_MSG);
            throw new IllegalArgumentException(e);
        }
    }
}
