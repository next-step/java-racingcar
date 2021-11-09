package step3;

public class CarRacingGame {

    private Car[] cars;
    private int numberOfRound;

    public CarRacingGame(int numberOfCar, int numberOfRound) {
        this.cars = new Car[numberOfCar];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        this.numberOfRound = numberOfRound;
    }

    public void start() throws Exception {
        for (int round = 0; round < numberOfRound; round++) {
            for (int i = 0; i < cars.length; i++) {
                cars[i].move();
            }
            GameOutput.println(cars);
            GameOutput.println("");
        }
    }
}
