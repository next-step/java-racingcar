package step3.model;

import java.util.List;

public class RacingCars {

    private List<RacingCar> participantCars;

    public RacingCars(List<RacingCar> participantCars) {
        this.participantCars = participantCars;
    }

    public void moveForward(int index){
        participantCars.get(index).executeMoveTrack();
    }


    public int[] targetRacingCarRoundResult(int index) {
        int size  = participantCars.get(index).getMoveTrack();
        int[] roundResult = new int[size];
        return roundResult;

    }

    public int size(){
        return participantCars.size();
    }
}
