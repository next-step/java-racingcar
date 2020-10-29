package step3.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private int position;

    public Car (){
        position = 0;
    }

    public void move(int movedNumber){
        if(isMove(movedNumber)){
            position++;
        }

    }
    private boolean isMove(int movedNumber){
        return movedNumber >= MOVE_CONDITION;
    }

    public int getCarPosition(){
        return this.position;
    }


}
