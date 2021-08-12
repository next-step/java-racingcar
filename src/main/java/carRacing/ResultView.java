package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    static void divideRound(int round) {
        if (round == 1) {
            System.out.println("실행결과");
        }
        System.out.println();
    }

    static void printPosition(Car car) {
        StringBuilder state = new StringBuilder();

        state.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            state.append("-");
        }

        System.out.println(state);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println();
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
