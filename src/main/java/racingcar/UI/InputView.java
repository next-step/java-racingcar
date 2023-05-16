package racingcar.UI;

import java.util.Scanner;
import util.InputParser;

public class InputView {
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return InputParser.stringToInteger(CONSOLE.nextLine());
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return InputParser.stringToInteger(CONSOLE.nextLine());
    }
}
