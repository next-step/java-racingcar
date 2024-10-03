package study.step_4.ui;

import java.util.List;

public class OutputView {

    public static final String COMMA = ", ";

    public void endGameMessage() {
        System.out.println(InfoMessage.EXECUTION_RESULT.getMessage());
    }

    public void cantDrive(String name, int distance) {
        if (distance == 0) {
            System.out.println(name + " : " + InfoMessage.WHEEL_LOSS.getMessage());
        }
    }

    public void SkidMark(String name, int distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print((InfoMessage.SKID_MARK.getMessage()));
        }
        System.out.println();
    }
}
