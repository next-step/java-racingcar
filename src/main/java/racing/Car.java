package racing;



public class Car {

    private Integer curMove = 0;
    private final MovableStrategy movableStrategy;
    private CarName name;

    private static final String CAR_STATE_BAR = "-";

    public Car(MovableStrategy movableStrategy, String name) {
        this.movableStrategy = movableStrategy;
        this.name = new CarName(name);
    }


    public int move(){
        if(movableStrategy.canMove()){
            curMove += 1;
        }

        return curMove;
    }


    public int getCurPosition(){
        return curMove;
    }

    public String getCurMoveStateExp(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curMove; i++) {
            sb.append(CAR_STATE_BAR);
        }
        return sb.toString();
    }

    public String getName(){
        return name.getName();
    }

    @Override
    public String toString(){
        return name+" , "+curMove;
    }
}
