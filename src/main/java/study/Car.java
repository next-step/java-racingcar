package study;

public class Car {
    private int moveCount;

    public void move(int number){
        if(number >= 4){
            this.moveCount++;
        }
    };

    public int getMoveCount() {
        return moveCount;
    }
}
