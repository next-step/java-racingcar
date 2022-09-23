package controller.impl;

import controller.InputView;
import enumeration.GameMessage;
import model.GameParam;

import java.util.InputMismatchException;
import java.util.Scanner;

import static enumeration.GameMessage.*;


public class ConsoleInputView implements InputView {

    @Override
    public GameParam getInputFromUser() {
        try (Scanner sc = new Scanner(System.in)) {
            printMessage(CAR_NUMBER_ASK_QUESTION);
            int carNumber = sc.nextInt();
            printMessage(TRY_NUMBER_ASK_QUESTION);
            int tryNumber = sc.nextInt();
            printMessage(RUN_RESULT_MSG);
            return new GameParam.GameParamBuilder()
                    .carNum(carNumber)
                    .tryNum(tryNumber)
                    .build();
        } catch (InputMismatchException e) {
            printMessage(RUN_FAIL_MSG);
            throw new IllegalArgumentException(e);
        }
    }

    private void printMessage(GameMessage message) {
        System.out.println(message.getMsg());
    }
}