package racing.domain;

public class Car {

    private int moveCount = 0;

    public void moveCar(boolean move){
        if(move){
            this.moveCount++;
        }
    }

    public int getMoveCount(){
        return this.moveCount;
    }

}
