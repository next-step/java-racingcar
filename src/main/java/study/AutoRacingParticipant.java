package study;

import java.util.ArrayList;
import java.util.List;

public class AutoRacingParticipant {
    private final List<RacingCar> autoRacingMembers = new ArrayList<>();

    public void participateGame(List<RacingCar> racingCar) {
        autoRacingMembers.addAll(racingCar);
    }
}
