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
            car.canGo();
        }
        outputView.resultPrint(carsPosition);
    }
}
