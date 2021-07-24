import racing.RacingCarInput;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarMain rcm = new RacingCarMain();
        rcm.run();
    }

    private void run() {
        RacingCarInput racingCarInput = new RacingCarInput();
        try {
            racingCarInput.requestInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
