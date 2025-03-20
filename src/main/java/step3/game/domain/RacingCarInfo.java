package step3.game.domain;

import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;
import step3.game.domain.car.Players;

import java.util.HashSet;
import java.util.Set;

public class RacingCarInfo {
    public final Players players;
    public final PositiveNumber tryCount;

    private RacingCarInfo(Players players, PositiveNumber tryCount) {
        this.players = players;
        this.tryCount = tryCount;
    }

    public static RacingCarInfo of(Set<CarName> carNames, PositiveNumber tryCount) {
        Set<Car> cars = new HashSet<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return new RacingCarInfo(new Players(cars), tryCount);
    }

    public void takeTurn() {
        players.takeTurn();
    }

    public Players getPlayers() {
        return players;
    }
}
