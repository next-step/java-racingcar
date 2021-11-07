package racingStep3;

import java.util.Random;

public class RacingCar {

    private final Position position;
    private static final Integer MAX_RANDOM = 9;
    private static final Integer MIN_GO_VALUE = 4;
    private static final String DASH = "-";

    public RacingCar(Position position) {

        this.position = position;
    }

    public static RacingCar create() {

        return new RacingCar(Position.create(0));
    }

    public void moveOrNot() {
        if(getRandomValue() >= MIN_GO_VALUE) {
            position.increaseLocation();
        }
    }

    public void moveOrNot(int forward) {
        if(forward >= MIN_GO_VALUE) {
            position.increaseLocation();
        }
    }

    public String printCar(RacingCar car) {
        int value = car.getPosition();
        String result = "-";

        for(int i = 0; i < value; i++) {
            result += DASH;
        }

        return result;
    }

    public int getPosition() {
        return this.position.getLocation();
    }

    public static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM);
    }

}
