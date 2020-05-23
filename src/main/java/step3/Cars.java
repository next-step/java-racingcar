package step3;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> carsPosition = new ArrayList<>();
    private OutputView outputView = new OutputView();

    public void makeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.carsPosition.add(new Car());
        }
    }

    public void playGame() {
        for (Car car:this.carsPosition) {
            int randomNumber = car.getRandomNumber();
            boolean greaterCheck = car.isGreater(randomNumber);
            car.setPosition(greaterCheck);
        }
        outputView.resultPrint(carsPosition);
    }
}
