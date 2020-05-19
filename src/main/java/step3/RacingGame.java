package step3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingGame {
    private ArrayList<Integer> carpositions;

    public RacingGame(int carCount ){
        for (int i = 0; i < carCount; i++) {
            this.carpositions.add(0);
        }
    }

    public void playGame() {
        Dice.canGo();
    }
}
