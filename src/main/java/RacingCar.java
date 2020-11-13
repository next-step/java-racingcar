public class RacingCar {

    public static final int INITIAL_POSITION = 1;
    public static final int FORWARD_STEP = 1;

    private final RacingCarMovingRule movingRule;
    private final int id;

    private int position;

    public RacingCar(RacingCarMovingRule movingRule, int id) {
        this.movingRule = movingRule;
        this.id = id;
        this.position = INITIAL_POSITION;
    }

    public void forward() {
        if (movingRule.shouldForward()) {
            position += FORWARD_STEP;
        }
    }

    public int getPosition() {
        return position;
    }

}
