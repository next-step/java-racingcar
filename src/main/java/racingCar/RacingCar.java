package racingCar;

public class RacingCar {
    public static void main(String[] args) {
        int numberOfCars = new PositiveNumber(InputView.getInput("자동차 대수를 입력해주세요.")).getValue();
        int numberOfRounds = new PositiveNumber(InputView.getInput("횟수를 입력해주세요.")).getValue();

        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(new RandomIntegerGenerator());
        }

        for (int round = 0; round < numberOfRounds; round++) {
            for (Car car : cars) {
                car.tryMove();
            }
            ResultView.printEachRound(cars);
        }
    }
}
