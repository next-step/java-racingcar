package study.racingcar;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InputView {

    String forwardMessage = "FORWARD";
    String stopMessage = "STOP";

    Random random = new Random();

    public int scanNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException imException) {
            System.out.println("숫자만 입력해주세요.");
            scanNumber();
        }
        return number;
    }

    public String forwardAndStop(int number) {
        if(number >= 4) {
            return forwardMessage;
        }
        return stopMessage;
    }

    public int randomNumber() {
        return random.nextInt(10);
    }
}
