package carRacing;

public class Car {

    public int move(int moveCount) {
        if (moveCount >= 4) {
            return 1;
        }
        return 0;
    }
}
