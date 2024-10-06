package race;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printCurrentRoundProgress(Cars cars) {
        Map<Integer, Integer> currentPositions = cars.getPositions();

        for(Map.Entry<Integer, Integer> status : currentPositions.entrySet()) {
            Integer id = status.getKey();
            Integer position = status.getValue();

            System.out.println(id + "\t: " + "=".repeat(position));
        }

        System.out.println();
    }
}
