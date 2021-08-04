package domain;

import util.RandomNumUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Participants {

    List<Car> participants;

    public Participants() {
        participants = new ArrayList<>();
    }

    public List<Car> readParticipants() {
        return participants;
    }

    public void addParticipants(String carName) {
        participants.add(new Car(carName));
    }

    public void playGame() {
        for(Car paticipant : participants) {
            paticipant.carMoveBehavior(RandomNumUtil.makeRandomNumber());
        }
    }

    public int readWinnerCarDistance() {
        participants.sort(Comparator.comparing(Car::readCarDistance).reversed());
        return participants.get(0).readCarDistance();
    }

}
