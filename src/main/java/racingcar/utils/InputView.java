package racingcar.utils;

import racingcar.domain.Positive;

import java.util.Scanner;

public class InputView {

    public static void questionsByText(String text) {
        System.out.println(text);
    }

    public static Positive inputNumber() {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();

        return Positive.create(inputText);
    }
}
