package racingcar.utils;

import racingcar.domain.PositiveNumber;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static void questionsByText(String text) {
        System.out.println(text);
    }

    public static PositiveNumber inputNumber() {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();

        return PositiveNumber.create(inputText);
    }

    public static List<String> inputString() {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();

        return List.of(inputText.split(","));
    }
}
