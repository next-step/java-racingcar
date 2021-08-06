package race.domain;

public class Game {

    private final Cars cars;

    public Game(Condition condition) {
        cars = new Cars(condition);
    }

    public void play() {
        cars.playUntilEnd();
    }

    public Cars findRegisteredCars() {
        return this.cars;
    }

}
