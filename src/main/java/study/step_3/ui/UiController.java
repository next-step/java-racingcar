package study.step_3.ui;

import java.util.Scanner;

public class UiController {

    Scanner sc = new Scanner(System.in);

    public int welcomeMessage() {
        System.out.println(InfoMessage.CAR_COUNT_QUESTION.getMessage());
        return getAnInt();
    }

    public int askAttemptMessage() {
        System.out.println(InfoMessage.ATTEMPT_COUNT_QUESTION.getMessage());
        return getAnInt();
    }

    public void endGameMessage() {
        System.out.println(InfoMessage.EXECUTION_RESULT.getMessage());
    }

    public void cantDrive(int distance) {
        if (distance == 0) {
            System.out.println(InfoMessage.WHEEL_LOSS.getMessage());
        }
    }

    public void SkidMark(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(InfoMessage.SKID_MARK.getMessage());
        }
        System.out.println();
    }

    private int getAnInt() {
        return Integer.parseInt(sc.next());
    }

}
