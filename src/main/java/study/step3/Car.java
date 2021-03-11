package study.step3;

public class Car{
    private static final Integer START_POSITION = 1;
    private String carName;
    private int position;
    public Car(String carName){
        this.carName = carName;
        this.position = START_POSITION;
    }
    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.move() >= NumberChecker.CONDITION_OF_START){
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
