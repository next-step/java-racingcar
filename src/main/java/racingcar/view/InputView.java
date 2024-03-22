package racingcar.view;

import racingcar.Racing;

import java.util.Scanner;

public class InputView {

    public static int inputNum(String str) {

        System.out.println(str);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
