package study;

public class Car {
    private int moveCount = 0;
    private static final int MOVE_ABLE_COUNT = 4;

    public void move(int number){
        if(number >= MOVE_ABLE_COUNT){
            this.moveCount++;
        }
    };

    public int getMoveCount() {
        return this.moveCount;
    }
}
