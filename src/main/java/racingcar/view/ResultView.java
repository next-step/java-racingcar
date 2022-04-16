package racingcar.view;

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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            builder.append(MOVED_EXPRESSION);
        }
        System.out.println(builder.toString());
    }

}
