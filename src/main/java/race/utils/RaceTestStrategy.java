package race.utils;

public class RaceTestStrategy implements PlayStrategy {

    PlayStrategy playStrategy;

    public RaceTestStrategy(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public boolean isValidForGoForward() {
        return playStrategy.isValidForGoForward();
    }

}
