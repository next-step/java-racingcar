package step5.domain;

import step5.strategy.MoveStrategy;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position){
        this.name = new Name(name);
        this.position = new Position(position);
    }


    public void move(MoveStrategy strategy) {
        if(strategy.movable()){
            this.position = this.position.nextPosition();
        }
    }


    public RacingRecord racingRecord(){
        return new RacingRecord(this.name, this.position);
    }

}


