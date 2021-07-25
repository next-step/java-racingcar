package step4;

import java.util.Scanner;

public class RacingGameInputView {
    public static RacingGameConfiguration getRacingGameConfigurationWithPrompt() {
        try (Scanner standardInput = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String carNames = standardInput.nextLine();

            System.out.println("자동차 대수는 몇 대 인가요?");
            int nCars = standardInput.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요?");
            int nTurns = standardInput.nextInt();

            return new RacingGameConfiguration(carNames, nCars, nTurns);
        }
    }
}
