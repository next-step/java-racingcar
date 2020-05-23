package mission1.racing;

import mission1.racing.view.RacingGameOutputView;

public class Movement {
    private int[] carPositions;
    private final int LIMIT = 4;
    private final int PASS_STEP = 1;
    private final int FAIL_STEP = 0;

    private RacingGameOutputView outputView = new RacingGameOutputView();
    private RacingRandom random = new RacingRandom();

    public Movement() {};
    public Movement(int carNumber) {
        carPositions = new int[carNumber];
    }

    public void move() {
        for(int i = 0; i < carPositions.length; i++) {
            carPositions[i] += moveCondition(random.random());
            outputView.resultView(carPositions[i]);
        }

        System.out.println();
    }

    public int moveCondition(int randomValue) {
        if (randomValue >= LIMIT) {
            return PASS_STEP;
        }

        return FAIL_STEP;
    }
}
