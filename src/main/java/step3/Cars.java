package step3;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> carList = new ArrayList<>();
    private OutputView outputView = new OutputView();

    public void makeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.carList.add(new Car());
        }
    }

    public void playGame() {
        for (Car car:this.carList) {
            int randomNumber = car.getRandomNumber();
            boolean greaterCheck = car.isGreater(randomNumber);
            if (greaterCheck) {
                car.goPosition();
            }
        }
        outputView.resultPrint(carList);
    }
}
