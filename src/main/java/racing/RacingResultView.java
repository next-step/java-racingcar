package racing;

import java.util.List;

public class RacingResultView {

    private static final String MOVE_CAR_EXPRESSION = "- ";

    private int carCount;

    public RacingResultView(int carCount) {
        this.carCount = carCount;
    }

    public void print(List<Integer> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            int carPosition = carPositions.get(i);
            if (i % carCount == 0) {
                System.out.println();
            }
            move(carPosition);
        }
    }

    private void move(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_CAR_EXPRESSION);
        }
        System.out.println();
    }
}
