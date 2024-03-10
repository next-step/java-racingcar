package step3;

public class Car {
    int moveNumber = 0;

    public void move(int moveNumber) {
        if (moveNumber >= 4 && moveNumber <= 9) {
            this.moveNumber += 1;
        }
    }

    public int getMoveNumber() {
        return this.moveNumber;
    }
}
