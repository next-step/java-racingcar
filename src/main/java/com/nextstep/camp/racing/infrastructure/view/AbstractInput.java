package com.nextstep.camp.racing.infrastructure.view;

import java.util.Scanner;
import java.util.stream.Stream;

public abstract class AbstractInput implements Element {
    protected String value;

    private static final String ERROR_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private final Scanner scanner;

    public AbstractInput() {
        this.scanner = new Scanner(System.in);
    }

    public AbstractInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void action() {
        requestInput();
    }

    private void requestInput() {
        System.out.println(getLabel());
        this.value = readValidValue();
    }

    private String readValidValue() {
        return Stream.generate(scanner::nextLine)
            .filter(answer -> {
                if (isValid(answer)) {
                    return true;
                }
                System.out.println(ERROR_MESSAGE);
                return false;
            })
            .findFirst()
            .orElseThrow();
    }

    protected abstract boolean isValid(String value);
}
