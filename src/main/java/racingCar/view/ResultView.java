package racingCar.view;

import java.util.List;

public class ResultView {

    private static final String MOVED_EXPRESSION = "-";

    public void printCarsMovingDistance (List<Integer> distances) {
        for (Integer distance: distances) {
            print(distance);
        }
        System.out.println(" ");
    }

    private void print(int distance) {
        String result = "";
        for (int i = 0; i < distance; i++) {
            result += MOVED_EXPRESSION;
        }
        System.out.println(result);
    }

}
