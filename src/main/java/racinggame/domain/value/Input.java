package racinggame.domain.value;

import racinggame.domain.entity.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String PARTICIPANT_NAME_DELIMETER = ",";

    private final String participants;
    private final int numOfRounds;

    public Input(String participants, int numOfRounds) {
        this.participants = participants;
        this.numOfRounds = numOfRounds;

    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public List<Car> getParticipantsAsCar() {
        return Arrays.stream(participants.split(PARTICIPANT_NAME_DELIMETER)).map(Car::new).collect(Collectors.toList());
    }
}
