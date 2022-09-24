package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Racer> racers = new ArrayList<>();
    private Umpire umpire = new Umpire();

    private GameInput input = new GameInput();

    private GameOutput output = new GameOutput();

    public void play() {
        output.printAskRacerCount();
        final int racerCount = input.racerCount();
        output.printRacerCount(racerCount);

        this.racerSetting(racerCount);

        output.printAskRoundCount();
        final int roundCount = input.roundCount();
        this.playRace(roundCount);

    }

    private void playRace(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            this.playRound();
        }
    }

    private void playRound() {
        for (Racer racer : racers) {
            this.isGoStraight(racer);
            output.printRacerAndCurrentLocation(racer);
        }
        output.printDivideRound();
    }

    private void isGoStraight(Racer racer) {
        umpire.resetAdvanceCondition();
        if (umpire.isGoStraight()) {
            racer.goStraight();
        }
    }

    private void racerSetting(int racerCount) {
        for (int i = 1; i <= racerCount; i++) {
            Racer racer = new Racer(i);
            racers.add(racer);
        }
    }
}
