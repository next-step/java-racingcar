package step5.model;

import step5.streategy.RacingGameMovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Participants players;

    public RacingGame(List<String> participants) {
        List<Car> playerList = new ArrayList<>();
        for (String member : participants) {
            playerList.add(new Car(member));
        }
        players = new Participants(playerList);
    }

    public Participants playGame() {
        players.moveCarWithStrategy(new RacingGameMovementStrategy());
        return players;
    }
}
