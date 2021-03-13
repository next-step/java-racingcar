package study.step3;

import study.step2.StringValidator;

public class Car{
    private static final int START_POSITION = 1;
    private String carName;
    private int position;
    public Car(String carName){
        StringValidator.checkCarNameSyntax(carName);
        this.carName = carName;
        this.position = START_POSITION;
    }
    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.isMove(carName.length())){
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
