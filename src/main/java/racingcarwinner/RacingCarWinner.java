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

    public int judgmentGoStop() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }
}
