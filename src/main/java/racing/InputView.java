package racing;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        RacingGame racingGame = new RacingGame(moveCount, carCount);
        List<Car> cars = racingGame.startRacing();

        System.out.println("실행 결과");
        cars.stream()
                .forEach(car -> OutputView.outputCarMovement(car));

    }
}
