package step5.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class RacingInputView {

    public static final String DELIMITER_OF_CAR_NAME = ",";

    private final BufferedReader br;
    private final InputValidation inputValidation;

    private String input;

    public RacingInputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.inputValidation = new InputValidation();
    }

    public String[] inputNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        input = readLine();

        validateNameOfCars();

        return input.split(DELIMITER_OF_CAR_NAME);
    }

    private void validateNameOfCars() {
        try {
            inputValidation.validateNameOfCars(input, DELIMITER_OF_CAR_NAME);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            input = readLine();
            validateNameOfCars();
        }
    }

    public int inputNumOfTry() {
        clearInput();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        input = readLine();

        validateNumOfTry();

        return Integer.parseInt(input);
    }

    private void clearInput() {
        input = "";
    }

    private void validateNumOfTry() {
        try {
            inputValidation.validateNumOfTry(input);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            input = readLine();
            validateNumOfTry();
        }
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException("", e);
        }
    }
}
