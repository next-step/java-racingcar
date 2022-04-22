package racing;

import com.sun.nio.sctp.IllegalReceiveException;

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
            viewCar(car.getMoves(), roundNumber);
        }
    }

    private static void viewCar(List<Boolean> moves, int roundNumber) {
        validateCarMoves(moves, roundNumber);

        System.out.println(getCarMoves(moves, roundNumber));
    }

    private static void validateCarMoves(List<Boolean> moves, int roundNumber) {
        if (moves.size() < roundNumber) {
            throw new IllegalReceiveException();
        }
    }

    private static StringBuilder getCarMoves(List<Boolean> moves, int roundNumber) {
        StringBuilder result = new StringBuilder();
        for (int round = 0; round <= roundNumber; round++) {
            result.append(getMove(moves, round));
        }
        return result;
    }

    private static String getMove(List<Boolean> moves, int round) {
        if (moves.get(round)) {
            return MOVE;
        }
        return NO_MOVE;
    }
}
