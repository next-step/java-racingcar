package study03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void move(int carIndex) {
        racingCarList.get(carIndex).move();
    }

    public void moveAll() {
        IntStream.range(0, racingCarList.size())
                .forEach(this::move);
    }

    public String tracking(int carIndex) {
        return this.getTotalTrack().substring(0, racingCarList.get(carIndex).getMoveDistance());
    }

    public String trackingAll() {
        return IntStream.range(0, racingCarList.size())
                .mapToObj(this::tracking)
                .collect(Collectors.joining("\n"));
    }

    public String getTotalTrack() {
        return totalTrack.toString();
    }

    //Test Code Only
    public void fixedMove(int fixedValue, int carIndex) {
        racingCarList.get(carIndex).fixedMove(fixedValue);
    }

    //Test Code Only
    public void fixedMoveAll(int[] fixedValues) {
        for (int i = 0 ; i < racingCarList.size() ; i++) {
            this.fixedMove(fixedValues[i], i);
        }
    }
}
