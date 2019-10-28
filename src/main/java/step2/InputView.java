package step2;

import java.util.*;

public class InputView {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        List<Integer> carPositions = new ArrayList<>(Collections.nCopies(numberOfCars, 0));

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            RacingGame racingGame = new RacingGame(numberOfCars, carPositions);
            carPositions = racingGame.move();
            resultView.printCarMovement(carPositions);
        }
    }
}
