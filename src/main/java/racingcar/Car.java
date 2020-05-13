package racingcar;

public class Car {
    private String name;
    private int position;
    private final CarMovingCondition carMovingCondition;

    public Car(CarMovingCondition carMovingCondition) {
        this("", carMovingCondition);
    }

    public Car(String name, CarMovingCondition carMovingCondition){
        this.name = name;
        this.position = 0;
        this.carMovingCondition = carMovingCondition;
    }

    public void tryMove() {
        if(carMovingCondition.canMove()){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName(){
        return name;
    }
}
