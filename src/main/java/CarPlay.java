import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarPlay {
    private int cars;
    private List<Integer> carList;

    public CarPlay() {

    }

    public CarPlay(InputReview inputReview) {
        this.cars = inputReview.getCars();
        this.carList = new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public List<Integer> carMovement(List<Integer> carList, int cars) {
        for (int i = 0; i < cars; i++) {
            if(addMoveCount()) carList.set(i, carList.get(i) + 1);
        }
        return carList;
    }

    public boolean addMoveCount() {
        int randomNum = generateRandomNum();
        return isMovingForward(randomNum);
    }

    public int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isMovingForward(int randomNumber) {
        return randomNumber >= 4;
    }
}
