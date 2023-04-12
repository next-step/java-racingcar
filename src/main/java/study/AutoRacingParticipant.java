package study;

import java.util.ArrayList;
import java.util.List;

public class AutoRacingParticipant {
    private final List<RacingCar> autoRacingMembers = new ArrayList<>();

    public void participateGame(List<RacingCar> racingCar) {
        autoRacingMembers.addAll(racingCar);
    }

    public void doGame(int numberOfGame) {
        for (int i = 0; i < numberOfGame; i++){
            gameEachRound();
        }
    }

    private void gameEachRound() {
        for (RacingCar autoRacingMember : autoRacingMembers) {

        }
    }
}
