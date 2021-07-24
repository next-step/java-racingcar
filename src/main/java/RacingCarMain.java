import racing.RacingCarInput;
import racing.RacingCarOperator;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarMain rcm = new RacingCarMain();
        rcm.run();
    }

    private void run() {
        RacingCarInput racingCarInput = new RacingCarInput();

        try {
            int[] racingInputInfo = racingCarInput.requestInput();
            RacingCarOperator racingCarOperator = new RacingCarOperator(racingInputInfo);
            racingCarOperator.Run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
