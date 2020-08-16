package step5.model;

import step5.streategy.MovementStrategy;

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

    public Participants playGame(MovementStrategy strategy) {
        players.moveCarWithStrategy(strategy);
        return players;
    }

    public List<String> getWinnerPlayers() {
        return players.getWinnerMember();
    }
}
