package race;

import java.util.List;

public class MoveResults {
    private final List<MoveResult> moveResults;

    public MoveResults(List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public List<MoveResult> getMoveResults() {
        return List.copyOf(moveResults);
    }

    public int getSize() {
        return moveResults.size();
    }
}
