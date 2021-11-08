package step3.domain.board;

import step3.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GameBoard {

    private final List<RoundBoard> roundBoards = new ArrayList<>();

    public void recordRound(Cars cars) {
        RoundBoard roundBoard = new RoundBoard();
        cars.recordRound(roundBoard);
        roundBoards.add(roundBoard);
    }

    public List<RoundBoard> getRoundBoards() {
        return unmodifiableList(roundBoards);
    }
}
