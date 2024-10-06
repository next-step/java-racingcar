package racingcar;

public class Race {
    Race(String[] carNames) {
        for (String carName : carNames) {
            Cars.addCar(new Car(carName));
        }
    }

    public void run() {
        for (Car car : Cars.getCars()) {
            Movement movement = new RandomMovement();
            car.move(movement.isMove());
        }
    }
}
