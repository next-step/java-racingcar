package com.hskim.nextstep.step03.ui;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.exception.ExceptionMessage;

import java.util.Scanner;

public class InputView extends View {

    private final Scanner scanner;

    public InputView() {

        scanner = new Scanner(System.in);
    }

    public int getIntegerFromConsoleInput() {

        String input = scanner.nextLine();

        if (StringUtils.isNumeric(input)) {

            return Integer.parseInt(input);
        }

        throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_STRING.getExceptionMessage());
    }

    public String getStringFromConsoleInput() {

        return scanner.nextLine();
    }
}
