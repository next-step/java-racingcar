package racingcar;

public class CarManager {
    CarManager(String[] carNames) {
        for (String carName : carNames) {
            Cars.addCar(new Car(carName));
        }
    }

    public void run(int racingCount) {
        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            raceOnce();
            ResultView.printResult();
        }
        ResultView.printWinners();
    }

    private void raceOnce() {
        for (Car car : Cars.getCars()) {
            Movement movement = new RandomMovement();
            car.move(movement.isMove());
        }
    }
}
