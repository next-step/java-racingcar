package racing.domain;

public class Car {

    static final int MOVE_CHECK_NUMBER = 4;

    private int moveCount = 0;

    public void moveCar(int randomNumber){
        if(randomNumber >= MOVE_CHECK_NUMBER){
            this.moveCount++;
        }
    }

    public int getMoveCount(){
        return this.moveCount;
    }

}
