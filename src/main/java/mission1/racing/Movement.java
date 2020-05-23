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
            carPositions[i] += moveCondition(random.random());
            view.resultView(carPositions[i]);
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
