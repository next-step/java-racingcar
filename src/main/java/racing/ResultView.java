package racing;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.List;

public class ResultView {

    public static void view(Circuit circuit) {
        System.out.println("실행 결과");
        List<Car> cars = circuit.getCars();
        for (int i = 0; i < circuit.getNumberOfRacing(); i++) {
            System.out.printf("%d 회 \n", i + 1);
            for (Car car : cars) {
                printMove(car.getMoves(), i);
            }
        }
    }

    private static void printMove(List<Boolean> moves, int index) {
        if (moves.size() < index) {
            throw new IllegalReceiveException();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            if (moves.get(i)) {
                result.append("-");
            }
        }

        System.out.println(result);
    }
}
