package racingcar;

public class GameSet {

    private String owners;
    private int givenRound;

    public GameSet(String owners, int givenRound) {
        this.owners = owners;
        this.givenRound = givenRound;
    }

    public String getOwners() {
        return owners;
    }

    public int getGivenRound() {
        return givenRound;
    }
}
