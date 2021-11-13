package step3.domain.value;

public class Input {
    private final int numOfParticipants;
    private final int numOfRounds;

    public Input(int numOfParticipants, int numOfRounds) {
        this.numOfParticipants = numOfParticipants;
        this.numOfRounds = numOfRounds;

    }

    public int getParticipantsNumber() {
        return numOfParticipants;
    }

    public int numOfRounds() {
        return numOfRounds;
    }
}
