package com.jaenyeong.mission2.racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Input {
    private final Output output;
    private final Scanner scanner;

    public InputView(final Output output) {
        this.output = output;
        this.scanner = new Scanner(System.in);
    }

    private int inputUntilCorrectIntType() {
        int input;
        do {
            input = inputIntValue();

        } while (input == CAN_NOT_READ);

        return input;
    }

    private int inputIntValue() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            printErrorMessage();
            scanner.next();
            return CAN_NOT_READ;
        }
    }

    private void printErrorMessage() {
        output.printErrWhenInvalidDataTypeInput();
    }

    @Override
    public int inputHowManyTryTimes() {
        return inputUntilCorrectIntType();
    }

    @Override
    public List<String> inputNamesOfTheCarsToBeRaced() {
        List<String> carNames;
        boolean invalid;

        do {
            carNames = inputNamesOfCars();

            invalid = trySetNamesOfCars(carNames);
        } while (invalid);

        return carNames;
    }

    private List<String> inputNamesOfCars() {
        try {
            String input = scanner.nextLine();
            return separateInputBySeparator(input);

        } catch (Exception e) {
            scanner.next();
            return new ArrayList<>();
        }
    }

    private boolean trySetNamesOfCars(final List<String> carNames) {
        if (invalidNamesOfCars(carNames)) {
            printErrorMessage();
            return true;
        }

        return false;
    }

    private boolean invalidNamesOfCars(final List<String> carNames) {
        if (carNames.size() <= EMPTY) {
            return true;
        }

        final List<String> collect = carNames.stream()
            .filter((name) -> name.length() > EMPTY)
            .collect(Collectors.toList());

        return !(carNames.size() == collect.size());
    }
}
