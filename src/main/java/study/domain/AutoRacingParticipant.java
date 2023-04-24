package study.domain;

import study.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AutoRacingParticipant {
    private final List<RacingCar> autoRacingMembers = new ArrayList<>();

    public void participateGame(List<RacingCar> racingCar) {
        autoRacingMembers.addAll(racingCar);
    }

    public List<RacingCar> gameEachRound() {
        for (RacingCar racingCar : autoRacingMembers) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            racingCar.moveOrStop(randomNumber);
        }
        return autoRacingMembers;
    }

    public List<String> getAllMaxMoveCountName() {
        return autoRacingMembers.stream()
                .filter(racingCar -> racingCar
                        .isSameMoveCount(getMaxCountValue()))
                .map(RacingCar::getName)
                .collect(Collectors
                        .toList());
    }

    private int getMaxCountValue() {
        return autoRacingMembers.stream()
                .max(Comparator
                        .comparing(RacingCar::getMoveCount))
                .orElseThrow(NoSuchElementException::new)
                .getMoveCount();
    }


}
