package step3.presentation;

import java.util.Scanner;
import step3.presentation.dto.RacingGameInput;

public class InputView {

        public static RacingGameInput scanAndGetValues() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("자동차 대수는 몇 대 인가요?");
                int carCntInput = scanner.nextInt();
                System.out.println("시도할 회수는 몇 회 인가요?");
                int tryCntInput = scanner.nextInt();
                return new RacingGameInput(carCntInput, tryCntInput);
        }

}
