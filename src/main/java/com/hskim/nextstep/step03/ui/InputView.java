package com.hskim.nextstep.step03.ui;

import com.hskim.nextstep.step02.utils.StringUtils;

import java.util.Scanner;

public class InputView extends View{

    private Scanner scanner;

    public InputView() {

        scanner = new Scanner(System.in);
    }

    public int getIntegerFromConsoleInput() {

        String input = scanner.nextLine();

        if(StringUtils.isNumeric(input)) {

            return Integer.parseInt(input);
        }

        System.out.println("Invalid input!!. Please input number string.");
        throw new IllegalArgumentException();
    }
}
