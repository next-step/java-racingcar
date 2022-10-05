package carracing.domain;

import java.util.Objects;

public class Car{
    private static final int CAN_MOVE_THRESHOLD = 4;
    private int position;
    private String participantName;

    public Car(String participantName) {
        this.position = 0;
        this.participantName = participantName;
    }

    public String getParticipantName() {
        return participantName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value > CAN_MOVE_THRESHOLD) {
            this.position += 1;
        }
    }
}
