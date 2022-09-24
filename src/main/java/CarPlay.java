import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CarPlay {

    private final int cars;
    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;

    public CarPlay(InputReview inputReview) {
        this.cars = inputReview.getCars();
    }

    public List<Integer> carMovement() {

        List<Integer> newCarList = renewedCarList();

        for (int i = 0; i < this.cars; i++) {
            if (addMoveCount())
                newCarList.set(i, newCarList.get(i) + 1);
        }
        return newCarList;
    }

    private List<Integer> renewedCarList() {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    private boolean addMoveCount() {
        int randomNum = generateRandomNum();
        return isMovingForward(randomNum);
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }
}
