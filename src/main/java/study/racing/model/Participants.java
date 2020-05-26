package study.racing.model;

import study.racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Car> participants = new ArrayList<>();

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void move() {
        for(Car car : participants) {
            car.move(RacingUtils.getRandomNumber());
        }
    }

    public List<Winner> getWinners() {
        Car anyWinner = Collections.max(participants);

        return participants.stream().filter(car -> car.getPosition()==anyWinner.getPosition()).map(Car::toWinner).collect(Collectors.toList());
    }
}
