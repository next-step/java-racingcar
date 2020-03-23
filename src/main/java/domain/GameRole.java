package domain;

import java.util.List;

public class GameRole {

    private List<String> names;
    private int numberOfAttempts;

    public GameRole(List<String> names, int numberOfAttempts) {
        this.names = names;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<String> getNames() {
        return names;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

}
