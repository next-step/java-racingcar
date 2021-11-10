package step3.domain.board;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GameBoard {

    private final List<RoundBoard> roundBoards = new ArrayList<>();

    public void recordRound(List<CarSnapshot> carSnapshots) {
        roundBoards.add(new RoundBoard(carSnapshots));
    }

    public List<RoundBoard> getRoundBoards() {
        return unmodifiableList(roundBoards);
    }
}
