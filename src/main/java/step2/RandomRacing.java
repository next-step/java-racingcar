package step2;

public class RandomRacing extends Racing {

    private static final int MINIMUM_RANDOM_VALUE = 4;

    public RandomRacing(InputView inputView) {
        super(inputView);
    }

    @Override
    public void move(Car car, int turn) {
        if (isPossibleToGo()) {
            car.go(turn);
        }
    }

    private boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= MINIMUM_RANDOM_VALUE;
    }
}
