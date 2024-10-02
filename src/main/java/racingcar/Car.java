package racingcar;

public class Car {
    private int moveCount;

    public void move(int random) {
        if (random < 0 || random > 9) {
            throw new IllegalArgumentException("Only accepts integers between 0 and 9: " + random);
        }
        if (random >= 4) moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
