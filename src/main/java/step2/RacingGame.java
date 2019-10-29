package step2;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Integer> carPositions;

    public RacingGame(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public List<Integer> move() {
        int length = carPositions.size();
        int position;
        int resultPosition;

        for (int i = 0; i < length; i++) {
            position = carPositions.get(i);
            resultPosition = iterateCarMove(position);
            carPositions.set(i, resultPosition);
        }

        return carPositions;
    }

    public int iterateCarMove(int position) {
        int randomNumber = generateRandom();
        int movedPosition = position;

        movedPosition = moveForward(randomNumber, movedPosition);

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