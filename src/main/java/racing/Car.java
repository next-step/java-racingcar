package racing;



public class Car {

    private Position curPosition;
    private final MovableStrategy movableStrategy;
    private CarName name;

    private static final String CAR_STATE_BAR = "-";

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

    public String getCurMoveStateExp(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getCurPosition(); i++) {
            sb.append(CAR_STATE_BAR);
        }
        return sb.toString();
    }

    public String getName(){
        return name.getName();
    }

    @Override
    public String toString(){
        return name+" , "+getCurPosition();
    }
}
