package racingcar.presentation;

import java.util.Scanner;
import racingcar.presentation.dto.RacingGameInput;

public class InputView {

        public static RacingGameInput scanAndGetValues() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                String carNamesInOneText = scanner.nextLine();
                System.out.println("시도할 회수는 몇 회 인가요?");
                int tryCount = scanner.nextInt();
                return new RacingGameInput(carNamesInOneText, tryCount);
        }

}
