package step3;

public class RacingCar {
    public static void main(String[] args) {
        RacingCarOutput.printCarCount();
        Integer carCount = RacingCarInput.carCount();
        RacingCarOutput.printTryCount();
        Integer tryCount = RacingCarInput.tryCount();

        Car[] cars = new Car[carCount];
        Car[] preparedCar = RacingSupport.prepareCar(cars);

        RacingSupport.race(preparedCar, tryCount);
    }
}
