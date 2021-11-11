package study03;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private final StringBuffer totalTrack;
    private final List<RacingCar> racingCarList = new ArrayList<>();

    public Track(int trackLength) {
        totalTrack = new StringBuffer();
        for (int i = 0 ; i < trackLength ; i++) {
            totalTrack.append('-');
        }
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public String tracking(int carIndex) {
        return this.getTotalTrack().substring(0, racingCarList.get(carIndex).getMoveDistance());
    }

    public String getTotalTrack() {
        return totalTrack.toString();
    }
}
