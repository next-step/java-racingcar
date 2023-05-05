package racingcar.domain.car;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car {

    private final static int MOVE_STRATEGY_NUMBER = 4;
    private Position position;
    private Name name;

    private Car(int position, String name) {
        this.position = Position.from(position);
        this.name = Name.from(name);
    }

    public static Car copy(Car car){
        return new Car(car.position.getPosition(), car.name.getName());
    }

    public static Car from(String name){
        return new Car(0, name);
    }
    public void move(NumberGenerator numberGenerator){
        if(numberGenerator.generate() >= MOVE_STRATEGY_NUMBER){
            this.position.move();
        }
    }

    public boolean isEqualPosition(int position){
        return this.getPosition() == position;
    }


    public int getPosition(){
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

}
