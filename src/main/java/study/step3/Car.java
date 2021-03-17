package study.step3;

import study.step2.StringValidator;

public class Car{

    private String carName;
    private Position position;

    public Car(String carName){
        StringValidator.checkCarNameSyntax(carName);
        this.carName = carName;
        this.position = new Position();
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.isMove()){
            position.move();
        }
    }

    public Position getPosition(){
        return position;
    }

    public String getCarName(){
        return carName;
    }
}
