package step3.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private int position;

    public Car (){
        position = 0;
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.move(MOVE_CONDITION)){
            position++;
        }

    }

    public int getCarPosition(){
        return this.position;
    }


}
