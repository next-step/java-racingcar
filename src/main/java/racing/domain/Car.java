package racing.domain;


public class Car {

    private Position curPosition;
    private final MovableStrategy movableStrategy;
    private CarName name;

    public Car(MovableStrategy movableStrategy, String name) {
        this.curPosition = new Position();
        this.movableStrategy = movableStrategy;
        this.name = new CarName(name);
    }


    public int move(){
        if(movableStrategy.canMove()){
            curPosition.move();
        }

        return curPosition.getPosition();
    }


    public int getCurPosition(){
        return curPosition.getPosition();
    }



    public String getName(){
        return name.getName();
    }

    @Override
    public String toString(){
        return name+" , "+getCurPosition();
    }
}
