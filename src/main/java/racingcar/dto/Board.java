package racingcar.dto;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Position> racingCarPositions;
    List<Name> racingCarNames;


    public Board() {
        this.racingCarNames = new ArrayList<>();
        this.racingCarPositions = new ArrayList<>();
    }

    public void record(Cars cars) {
        this.racingCarNames = cars.getNames();
        this.racingCarPositions = cars.getCarsPositions();
    }

    public List<Position> getRacingCarPositions() {
        return racingCarPositions;
    }

    public List<Name> getRacingCarNames() {
        return racingCarNames;
    }
}
