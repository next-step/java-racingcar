package study.race.model;

public class RaceResister {

    private String[] carNames;
    private int roundOfTrack;

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getRoundOfTrack() {
        return this.roundOfTrack;
    }

    public void setCarNames(String[] names) {
        this.carNames = names;
    }

    public void setRoundOfTrack(int roundOfTrack) {
        this.roundOfTrack = roundOfTrack;
    }
}
