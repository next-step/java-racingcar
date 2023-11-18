package carracing.view;

import carracing.domain.car.Car;
import carracing.domain.car.Winners;
import carracing.domain.game.RacingGame;

public class ResultView {
    public static void printResultPhrase() {
        System.out.println("실행 결과");
    }

    public static void printMovingResult(RacingGame racingGame) {
        for (Car car : racingGame.cars()) {
            String result = "-".repeat(Math.max(0, car.movingDistance()));
            System.out.println(car.name() + " : " + result);
        }
        empty();
    }

    public static void empty() {
        System.out.println("");
    }

    public static void printWinners(Winners winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners.winners()) {
            sb.append(winner.name()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
