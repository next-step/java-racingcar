package step3.model;

public class Car{
    private int position =0;

    public Car(){

    }

    public void move(int movePoint){
        if(isMove(movePoint)){
            this.position++;
        }
    }

    public boolean isMove(int movePoint){
        return movePoint >= 4;
    }

    public int getPosition(){
        return position;
    }
}
