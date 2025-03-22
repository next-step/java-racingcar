
public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int position;

    public int move() {
        return move(new RandomNumberGenerator());
    }

    public int move(NumberGenerator numberGenerator) {
        if (canMove(numberGenerator)) position++;
        return position;
    }

    private boolean canMove(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

}