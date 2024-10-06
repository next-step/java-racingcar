package race;

import java.util.Map;

public class ResultView {

    public void printCurrentRoundProgress(Cars cars) {
        Map<String, Integer> currentPositions = cars.getPositions();

        for(Map.Entry<String, Integer> status : currentPositions.entrySet()) {
            String name = status.getKey();
            Integer position = status.getValue();

            System.out.println(name + "\t: " + "=".repeat(position));
        }

        System.out.println();
    }
}
