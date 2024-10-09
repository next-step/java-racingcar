package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private final int carCount;

    private final int tryCount;

    public RaceGame(UserInputData userInput) {
        this.carCount = userInput.getCarCount();
        this.tryCount = userInput.getTryCount();
    }

    public List<Positions> playGame(final MoveStrategy moveStrategy) {
        Cars cars = new Cars(carCount);

        return playRounds(cars, moveStrategy);
    }

    public List<Positions> playRounds(Cars cars, MoveStrategy moveStrategy) {
        List<Positions> allRoundPositions = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            Positions positions = playRound(cars, moveStrategy);
            allRoundPositions.add(positions);
        }
        return allRoundPositions;
    }

    public Positions playRound(Cars cars, MoveStrategy moveStrategy) {
        Positions positions = new Positions();
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
            positions.save(new Position(car.getPosition()));
        }

        return positions;
    }

}
