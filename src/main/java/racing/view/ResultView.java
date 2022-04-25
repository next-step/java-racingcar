package racing.view;

import racing.Circuit;
import racing.car.Car;

import java.util.List;

public class ResultView {
    private final static String MOVE = "-";

    public static void view(Circuit circuit) {
        System.out.println("실행 결과");
        for (int round = 0; round < circuit.getTotalRound(); round++) {
            viewRound(circuit.getCars(), round);
        }
        System.out.println(circuit.whoIsWinners() + "가 최종 우승하였습니다.");
    }

    private static void viewRound(List<Car> cars, int round) {
        System.out.printf("%d 회 \n", round + 1);

        for (Car car : cars) {
            viewCar(car, round);
        }
    }

    private static void viewCar(Car car, int round) {
        System.out.println(car.getName() + ": " + getCarDistanceByRound(car, round));
    }

    private static StringBuilder getCarDistanceByRound(Car car, int round) {
        StringBuilder distance = new StringBuilder();
        distance.append(MOVE.repeat(Math.max(0, car.getRoundDistance(round) + 1)));
        return distance;
    }
}
