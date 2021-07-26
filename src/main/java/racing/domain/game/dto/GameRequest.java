package racing.domain.game.dto;

import racing.domain.car.entity.Car;
import racing.domain.car.entity.Cars;
import racing.domain.car.vo.Name;
import racing.domain.game.RacingGame;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameRequest {
    private String carNames;
    private int turnSize;

    private static final String NAME_DELIMITER = ",";

    public GameRequest(String carNames, int turnSize) {
        this.carNames = carNames;
        this.turnSize = turnSize;
    }

    private Turns asTurn() {
        return new Turns(turnSize);
    }

    private Cars asCars(Function<Name, Car> carCtor) {
        String[] strNameSplitValues = carNames.split(NAME_DELIMITER);

        return new Cars(
                Arrays.stream(strNameSplitValues)
                        .map(Name::new)
                        .map(carCtor)
                        .collect(Collectors.toSet())
        );
    }

    public RacingGame asGame(Function<Name, Car> carCtor) {
        return new RacingGame(asCars(carCtor), asTurn());
    }
}
