package controller.impl;

import controller.InputValidator;
import controller.InputView;
import model.GameParam;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleInputView implements InputView {

    private static final String DEFAULT_DELIMITER = ",";

    @Override
    public GameParam getInputFromUser() {
        try (Scanner sc = new Scanner(System.in)) {
            InputValidator validator = new InputValidator();
            System.out.println(CAR_NAME_ASK_QUESTION);
            String[] carNames = sc.next().split(DEFAULT_DELIMITER);
            validator.validateName(carNames);
            System.out.println(TRY_NUMBER_ASK_QUESTION);
            int tryNumber = sc.nextInt();
            System.out.print(RUN_RESULT_MSG);
            return GameParam.paramWithCarNamesAndTryNum(carNames, tryNumber);
        } catch (InputMismatchException e) {
            System.out.println(RUN_FAIL_MSG);
            throw new IllegalArgumentException(e);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_CAR_NAME_MSG);
            throw e;
        }
    }
}
