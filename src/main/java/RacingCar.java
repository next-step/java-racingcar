public class RacingCar {

    public static final int INITIAL_POSITION = 1;
    public static final int FORWARD_STEP = 1;

    private final String name;
    private final RacingCarMovingRule movingRule;

    private int position;

    public RacingCar(String name, RacingCarMovingRule movingRule) {
        this.name = name;
        this.movingRule = movingRule;
        this.position = INITIAL_POSITION;
    }

    public void forward() {
        if (movingRule.shouldForward()) {
            position += FORWARD_STEP;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}

