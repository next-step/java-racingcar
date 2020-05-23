package mission1.racing;

import java.util.Scanner;

public class RacingGameView {
    private Scanner scanner = new Scanner(System.in);

    public int inputView(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public void resultView(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
