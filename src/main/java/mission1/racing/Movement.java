package mission1.racing;

public class Movement {
    private int[] carPositions;

    private RacingGameView view = new RacingGameView();
    private RacingRandom random = new RacingRandom();

    public Movement() {};
    public Movement(int carNumber) {
        carPositions = new int[carNumber];
    }

    public void move() {
        for(int i = 0; i < carPositions.length; i++) {
            carPositions[i] += moveCondition();
            view.resultView(i);
        }
    }

    private int moveCondition() {
        if (random.random() >= 4) {
            return 1;
        }

        return 0;
    }
}
