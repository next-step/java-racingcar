package step3;

public class Car {

    private int position;

    public Car(){
        this(0);
    }

    public static Car withPosition(int position){
        return new Car(position);
    }

    private Car(int position){
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }


    public void moveWithStrategy(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
            this.position += 1;
        }
    }



}



