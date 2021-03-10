package study.step3;

public class Car{
    private static final Integer START_POSITION = 1;
    private String carName;
    private int position;
    private MoveStrategy moveStrategy;
    public Car(String carName,MoveStrategy moveStrategy){
        this.carName = carName;
        this.moveStrategy = moveStrategy;
        this.position = START_POSITION;
    }
    public void move(){
        if(moveStrategy.move()){
            position++;
        }
    }

    public int getPosition(){
        return position;
    }
    public String getCarName(){
        return carName;
    }
}
