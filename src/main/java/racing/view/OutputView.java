package racing.view;

import java.util.List;
import racing.model.Cars;

public class OutputView {

    public static final String RESULT_LABEL = "실행 결과";

    public static void printResultLabel() {
        System.out.println(RESULT_LABEL);
    }

    public static void printResult(Cars cars) {
        List<Integer> positions = cars.getPositions();
        for (Integer position : positions) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }

}
