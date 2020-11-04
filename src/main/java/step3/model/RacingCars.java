package step3.model;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private List<RacingCar> participantCars;
    private int totalRound;

    public RacingCars(List<RacingCar> participantCars, int totalRound) {
        this.participantCars = participantCars;
        this.totalRound = totalRound;
    }

    public void moveForward(int index) {
        participantCars.get(index).executeMoveTrack();
    }

    public int size() {
        return participantCars.size();
    }

    public int getTotalRound() {
        return this.totalRound;
    }

    public void roundResult() {
        for (int i = 0; i < participantCars.size(); i++) {
            System.out.println(String.join("", Collections.nCopies(participantCars.get(i).movePosition(), "-")));
        }
        System.out.println("");
    }
}
