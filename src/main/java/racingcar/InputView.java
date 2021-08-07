package racingcar;

import java.util.Scanner;

public class InputView {
    public int getCarNumber() {
        printIntroMessage("자동차 대수는 몇 대 인가요?");
        return getUserInput();
    }

    public int getTrialNumber() {
        printIntroMessage("시도할 회수는 몇 회인가요?");
        return getUserInput();
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextInt();
    }

    private void printIntroMessage(String message){
        System.out.println(message);
    }
}
