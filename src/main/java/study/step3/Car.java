package study.step3;

import study.step2.StringValidator;

public class Car{

    private String carName;
    private Position position;

    public Car(String carName){
        this(carName,new Position());
    }

    public Car(String carName,Position position){
        StringValidator.checkCarNameSyntax(carName);
        this.carName = carName;
        this.position = position;
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
