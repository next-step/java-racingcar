package racingcarwinner;

public class RacingCarWinner {

    private String participantName;
    private int carMovingCount;
    private String[] participantNames;
    private int participantNumber;

    public RacingCarWinner(String participantName, int carMovingCount) {
        this.participantName = participantName;
        this.carMovingCount = carMovingCount;
    }

    public void splitParticipantName() {
        participantNames = participantName.split(",");
        participantNumber = participantNames.length;
    }

}
