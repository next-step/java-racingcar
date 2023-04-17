package carracing.view;

import java.util.Scanner;

public class InputView {
    private int amount;
    private int track;

    public InputView() {
        question();
    }

    public int getAmount() {
        return amount;
    }

    public int getTrack() {
        return track;
    }

    public void question() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.amount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.track = scanner.nextInt();
    }
}
