package mission1.racing;

public class Movement {
    private int[] carPositions = {0, 0, 0};
    RacingRandom random = new RacingRandom();

    public void move() {
        for(int i = 0; i < carPositions.length; i++) {
            carPositions[i] += moveCondition();
            showCarStatus(i);
        }
    }

    private int moveCondition() {
        if (random.random() >= 4) {
            return 1;
        }

        return 0;
    }

    private void showCarStatus(int i) {
        for(int j = 0; j < carPositions[i]; j++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
