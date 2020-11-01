package step3.model;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> participantCars;

    public RacingCars(List<RacingCar> participantCars) {
        this.participantCars = participantCars;
    }


    public RacingCar getParticipantCar(int entryNumber) {
        return this.participantCars.get(entryNumber);
    }

    public int size(){
        return participantCars.size();
    }
}
