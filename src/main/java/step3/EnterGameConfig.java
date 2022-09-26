package step3;

import java.util.Scanner;

public class EnterGameConfig {
    private final Scanner scanner = new Scanner(System.in);
    public final int participantNumber;
    public final int iterate;

    public EnterGameConfig() {
        this.participantNumber = this.enterParticipantNumber();
        this.iterate = this.enterIterate();
        this.inputClose();
    }

    private int enterParticipantNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(this.scanner.nextLine());
    }

    private int enterIterate() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(this.scanner.nextLine());
    }

    private void inputClose() {
        this.scanner.close();
    }
}
