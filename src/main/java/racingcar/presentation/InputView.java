package racingcar.presentation;

import java.util.Scanner;
import racingcar.presentation.dto.RacingGameInput;

public class InputView {

        public static RacingGameInput scanAndGetValues() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("자동차 대수는 몇 대 인가요?");
                int carCountnput = scanner.nextInt();
                System.out.println("시도할 회수는 몇 회 인가요?");
                int tryCntInput = scanner.nextInt();
                return new RacingGameInput(carCountnput, tryCntInput);
        }

}
