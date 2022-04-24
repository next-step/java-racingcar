package racing;

import java.util.List;

public class ResultView {
    private final static String NO_MOVE = "";
    private final static String MOVE = "-";

    public static void view(Circuit circuit) {
        System.out.println("실행 결과");
        for (int round = 0; round < circuit.getTotalRound(); round++) {
            viewRound(circuit.getCars(), round);
        }
    }

    private static void viewRound(List<Car> cars, int round) {
        System.out.printf("%d 회 \n", round + 1);

        for (Car car : cars) {
            viewCar(car, round);
        }
    }

    private static void viewCar(Car car, int round) {
        System.out.println(car.getCarName() + ": " + getCarDistance(car, round));
    }

    private static StringBuilder getCarDistance(Car car, int round) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i <= round; i++) {
            distance.append(move(car.isRoundMove(i)));
        }
        return distance;
    }

    private static String move(Boolean isMove) {
        if (isMove) {
            return MOVE;
        }
        return NO_MOVE;
    }
}
