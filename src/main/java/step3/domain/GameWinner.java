package step3.domain;

public class GameWinner {
    private Car car;

    private GameWinner() {
    }

    public GameWinner(Car car) {
        this.car = car;
    }

    public String getCarName() {
        return car.getName();
    }
}
