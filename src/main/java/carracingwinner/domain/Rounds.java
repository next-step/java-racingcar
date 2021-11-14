package carracingwinner.domain;

public class Rounds {

    private int roundCount;

    public Rounds(int tryCount) {
        this.roundCount = tryCount;
    }

    public void playOneRound(Cars cars) {
        roundCount--;
        cars.move();
    }

    public boolean isEnd() {
        return roundCount > 0;
    }

}
