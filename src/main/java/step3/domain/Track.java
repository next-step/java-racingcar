package step3.domain;

public class Track implements Comparable<Track> {
    private final int trackNumber;
    private RacingCar racingCar;

    public Track(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void entrance(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    public void exit() {
        this.racingCar = null;
    }

    public int carPosition() {
        return racingCar.position();
    }

    @Override
    public int compareTo(Track o) {
        return Integer.compare(trackNumber, o.trackNumber);
    }
}
