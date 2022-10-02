import java.util.Scanner;

public class CarRacingApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int carCount = InputView.inputNumber(scanner, "자동차 대수는 몇 대 인가요?");
            int roundCount = InputView.inputNumber(scanner, "시도할 회수는 몇 회 인가요?");

            CarRacingExecutor carRacingExecutor = new CarRacingExecutor(carCount);

            for(; roundCount > 0; roundCount--) {
                ResultView.printCarRacingResult(carRacingExecutor);
                carRacingExecutor.proceedNextRound();
            }
        }
    }
}
