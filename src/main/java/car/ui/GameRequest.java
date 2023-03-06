package car.ui;

import car.domain.Car;

import java.util.List;

public class GameRequest {

    private final List<Car> participants;
    private final int moveCount;

    public GameRequest(List<Car> participants, int moveCount) {
        this.participants = participants;
        this.moveCount = moveCount;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
