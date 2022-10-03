package racingcarwinner;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public String enterParticipantName() {
        return sc.nextLine();
    }

    public int enterCarMovingCount() {
        return sc.nextInt();
    }
}
