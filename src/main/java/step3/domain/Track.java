package step3.domain;

public class Track implements Comparable<Track> {
    private final int trackNumber;
    private RacingCar racingCar;

    public Track(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    protected void entrance(RacingCar racingCar) {
        this.racingCar = racingCar;
        racingCar.resetPosition();
    }

    public RacingCar exit() {
        final RacingCar racingCar = this.racingCar;
        this.racingCar = null;
        return racingCar;
    }

    public int carPosition() {
        if (isEmpty()) {
            throw new IllegalStateException("해당 track에는 car가 존재하지 않습니다.");
        }

        return racingCar.position();
    }

    public boolean isEmpty() {
        return racingCar == null;
    }

    @Override
    public int compareTo(Track o) {
        return Integer.compare(trackNumber, o.trackNumber);
    }

    protected void signalToForward() {
        if (isEmpty()) {
            return;
        }

        this.racingCar.steeringToForward();
    }
}
