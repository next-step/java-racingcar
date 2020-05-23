package mission1.racing;

import mission1.racing.view.RacingGameOutputView;

public class Movement {
    private int[] carPositions;

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
        if (randomValue >= 4) {
            return 1;
        }

        return 0;
    }
}
