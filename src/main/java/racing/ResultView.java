package racing;

import java.util.List;

public class ResultView {
    private final static String NO_MOVE = "";
    private final static String MOVE = "-";

    public static void view(Circuit circuit) {
        System.out.println("실행 결과");
        for (int roundNumber = 0; roundNumber < circuit.getNumberOfRacing(); roundNumber++) {
            viewRound(circuit.getCars(), roundNumber);
        }
    }

    private static void viewRound(List<Car> cars, int roundNumber) {
        System.out.printf("%d 회 \n", roundNumber + 1);

        for (Car car : cars) {
            viewCar(car, roundNumber);
        }
    }

    private static void viewCar(Car car, int roundNumber) {
        System.out.println(getCarMoves(car, roundNumber));
    }

    private static StringBuilder getCarMoves(Car car, int roundNumber) {
        StringBuilder result = new StringBuilder();
        for (int round = 0; round <= roundNumber; round++) {
            result.append(move(car.isRoundMove(round)));
        }
        return result;
    }

    private static String move(Boolean isMove) {
        if (isMove) {
            return MOVE;
        }
        return NO_MOVE;
    }
}
