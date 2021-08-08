package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Rounds {
    private Round[] rounds;

    public Rounds(int totalRoundNum) {
        this.rounds = new Round[totalRoundNum];
    }

    public void moveCarsForEachRound(Cars cars, MoveRule moveRule) {
        for (int i = 0; i < rounds.length; i++) {
            Round newRound = new Round(cars);
            cars = newRound.moveCars(moveRule);
            rounds[i] = newRound;
        }
    }
}
