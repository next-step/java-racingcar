package carRace.view;

import static carRace.error.ErrorMessage.ILLEGAL_STATE;
import static carRace.error.ErrorMessage.INVALID_INPUT_EMPTY;
import static carRace.error.ErrorMessage.INVALID_INPUT_EXCEED_LENGTH;
import static carRace.error.ErrorMessage.INVALID_INPUT_TYPE_INT;
import static carRace.error.ErrorMessage.INVALID_INPUT_TYPE_STRING;
import static carRace.error.ErrorMessage.UNEXPECTED_ERROR;

import carRace.error.exception.CarNameExceedException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputRaceTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요\n");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException(INVALID_INPUT_TYPE_STRING.getMessage(), e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(INVALID_INPUT_EMPTY.getMessage(), e);
        } catch (IllegalStateException e) {
            throw new RuntimeException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UNEXPECTED_ERROR.getMessage(), e);
        }
    }

    public static String inputCarGroupName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        try {
            String carNames = scanner.nextLine();
            checkCarNamesMoreThan5Letters(carNames.split(","));
            return carNames;
        } catch (CarNameExceedException e) {
            throw new CarNameExceedException(e.getMessage());
        } catch (InputMismatchException e) {
            throw new RuntimeException(INVALID_INPUT_TYPE_INT.getMessage(), e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(INVALID_INPUT_EMPTY.getMessage(), e);
        } catch (IllegalStateException e) {
            throw new RuntimeException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UNEXPECTED_ERROR.getMessage(), e);
        }
    }


    private static void checkCarNamesMoreThan5Letters(String[] carNames) {
        boolean isMoreThan5Letters = Arrays.stream(carNames)
            .anyMatch(carName -> carName.length() > 5);
        if (isMoreThan5Letters) {
            throw new CarNameExceedException(INVALID_INPUT_EXCEED_LENGTH.getMessage());
        }
    }
}
