package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPositions = {0, 0, 0};
    private List<Integer> resultPositions;

    public RacingGame(int time) {
        this.time = time;
        resultPositions = new ArrayList<>();
    }

    public List<Integer> move() {
        // TODO 구현
        int length = carPositions.length;
        int position;
        int resultPosition;

        for(int i = 0; i < length; i++) {
            position = carPositions[i];
            resultPosition = iterateCarMove(position);
            resultPositions.add(resultPosition);
        }

        return resultPositions;
    }

    public int iterateCarMove(int position) {
        int randomNumber;
        int movedPosition = position;

        for(int i = 0; i < time; i++) {
            randomNumber = generateRandom();
            movedPosition = moveForward(randomNumber, movedPosition);
        }

        return movedPosition;
    }

    public int generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public int moveForward(int number, int position) {
        if (number >= 4) {
            position = position + 1;
        }

        return position;
    }
}