package racingcarwinner;

import java.util.Map;

public class Car {
    private Map<String, Integer> participant;

    public Map<String, Integer> getParticipant() {
        return this.participant;
    }

    public void setParticipant(Map<String, Integer> participant) {
        this.participant = participant;
    }
}
