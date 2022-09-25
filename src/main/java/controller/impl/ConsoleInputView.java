package controller.impl;

import controller.InputView;
import model.CarName;
import model.GameParam;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConsoleInputView implements InputView {

    private static final String DEFAULT_DELIMITER = ",";

    @Override
    public GameParam getInputFromUser() {
        try (Scanner sc = new Scanner(System.in)) {
            List<CarName> carNames = getCarName(sc);
            int tryNumber = getTryNumber(sc);
            return GameParam.paramWithCarNamesAndTryNum(carNames, tryNumber);
        } catch (InputMismatchException e) {
            System.out.println(RUN_FAIL_MSG);
            throw new IllegalArgumentException(e);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_CAR_NAME_MSG);
            throw e;
        }
    }

    private int getTryNumber(Scanner sc) {
        System.out.println(TRY_NUMBER_ASK_QUESTION);
        return sc.nextInt();
    }

    private List<CarName> getCarName(Scanner sc) {
        System.out.println(CAR_NAME_ASK_QUESTION);
        return Arrays.stream(sc.next().split(DEFAULT_DELIMITER)).map(CarName::new).collect(Collectors.toList());
    }
}
