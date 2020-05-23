package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = null;
    private OutputView outputView = new OutputView();

    public void makeCars(int carCount) {
        carList = new ArrayList<>();
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
