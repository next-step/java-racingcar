package racingcarwinner;

import java.util.HashMap;
import java.util.Map;

public class RacingCarWinner {

    private String participantName;
    private int carMovingCount;
    private String[] participantNames;
    private int participantNumber;
    private Car car = new Car();

    public RacingCarWinner(String participantName, int carMovingCount) {
        this.participantName = participantName;
        this.carMovingCount = carMovingCount;
    }

    public void splitParticipantName() {
        participantNames = participantName.split(",");
        participantNumber = participantNames.length;
    }

    public void enterParticipantInformation() {
        Map<String, Integer> participantInformation = new HashMap<>();
        splitParticipantName();
        for (String name : participantNames) {
            participantInformation.put(name, 0);
        }
        car.setParticipant(participantInformation);
    }
}
