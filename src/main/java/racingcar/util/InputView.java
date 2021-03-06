package racingcar.util;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }
}
