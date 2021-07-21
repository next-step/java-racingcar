package racingcar.view;

import java.util.Scanner;

public class InputView {

    public int inputInteger(String printMessage) {
        System.out.println(printMessage);

        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
