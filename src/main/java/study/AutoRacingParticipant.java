package study;

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

    public void doGame(int numberOfGame) {
        for (int i = 0; i < numberOfGame; i++) {
            gameEachRound();
            ResultView.lineChangeEachRoundFinish();
        }
        ResultView.printName(getAllMaxMoveCountName());
    }

    private void gameEachRound() {

        for (RacingCar racingCar : autoRacingMembers) {
            ResultView.printName(racingCar.getName());
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            racingCar.moveOrStop(randomNumber);
            ResultView.printResultEachRound(racingCar.getMoveCount());
        }

    }

    private int getMaxCountValue() {
        return autoRacingMembers.stream()
                .max(Comparator
                        .comparing(RacingCar::getMoveCount))
                .orElseThrow(NoSuchElementException::new)
                .getMoveCount();
    }

    private List<String> getAllMaxMoveCountName() {
        return autoRacingMembers.stream()
                .filter(racingCar -> racingCar
                        .getMoveCount() == getMaxCountValue())
                .map(RacingCar::getName)
                .collect(Collectors
                        .toList());
    }
}
