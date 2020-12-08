package cargameracing;

/**
 * Domain(Model) Role
 * @author minji
 */
public class CarRacingGame {
    Car[] cars;

    public CarRacingGame(int carCount) {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public void playGame(int carCount) {
        for (int j = 0; j < carCount; j++ )
            cars[j].junjinUp();
    }

    public Car[] getCars() {
        return cars;
    }

}
