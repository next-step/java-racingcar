package step3.domain;

public class RacingCar implements Comparable<RacingCar> {
    private final int track;

    public RacingCar(int track) {
        this.track = track;
    }

    public int getTrack() {
        return track;
    }

    public void move() {
        //TODO: move
    }

    @Override
    public int compareTo(RacingCar target) {
        return Integer.compare(track, target.getTrack());
    }
}
