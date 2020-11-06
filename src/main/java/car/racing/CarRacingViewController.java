package car.racing;


import java.util.stream.IntStream;

public class CarRacingViewController {

    private final CarRacingContract.View resultView;
    private final CarRacingManager carRacingManager;

    public CarRacingViewController(CarRacingContract.View resultView, CarRacingManager carRacingManager) {
        this.resultView = resultView;
        this.carRacingManager = carRacingManager;
    }

    public void input(int numOfCar, int tryCount) {
        resultView.resultTitle();

        carRacingManager.setupCars(numOfCar);
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    resultView.forward(carRacingManager.forwardEachCar());
                    resultView.newLine();
                });
    }
}