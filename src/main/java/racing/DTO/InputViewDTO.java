package racing.DTO;

public class InputViewDTO {
    private String participants;
    private int round;

    public InputViewDTO() {
        this.participants = participants;
        this.round = round;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "InputViewDTO{" +
                "participants='" + participants + '\'' +
                ", round=" + round +
                '}';
    }
}
