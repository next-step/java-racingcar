package me.devyonghee.racingcar.view;

import me.devyonghee.racingcar.utility.Assert;

import java.io.PrintStream;
import java.util.Scanner;

public final class InputView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CYCLE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final PrintStream guidePrinter;
    private final Scanner scanner;

    private InputView(Scanner scanner, PrintStream guidePrinter) {
        Assert.notNull(scanner, "'scanner' must not be null");
        Assert.notNull(guidePrinter, "'guidePrinter' must not be null");
        this.scanner = scanner;
        this.guidePrinter = guidePrinter;
    }

    public static InputView of(Scanner scanner, PrintStream output) {
        return new InputView(scanner, output);
    }

    public String carNames() {
        guidePrinter.println(CAR_NAMES_INPUT_MESSAGE);
        return scanner.next();
    }

    public int cycleCount() {
        guidePrinter.println(CYCLE_COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}

