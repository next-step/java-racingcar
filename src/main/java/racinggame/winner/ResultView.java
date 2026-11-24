package racinggame.winner;

import java.util.List;
import java.util.StringJoiner;

final class ResultView {

    private ResultView() {
    }

    static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    static void printWinners(List<Car> winners) {
        StringJoiner names = new StringJoiner(", ");
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
