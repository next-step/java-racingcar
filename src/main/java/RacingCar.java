import java.util.Random;

public class RacingCar {
    private static final Random random = new Random();
    private InputView input;
    private ResultView result;


    public void host() {
        input = new InputView();
        result = new ResultView(input.getCarNumber());

        for (int i = 0; i < input.getTryCount(); i++) {
            race(input.getCarNumber());
            result.read();
        }
    }

    private void race(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            moveOrNot(i);
        }
    }

    private void moveOrNot(int carIndex) {
        if (canMove()) {
            result.write(carIndex);
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= 4;
    }

}
