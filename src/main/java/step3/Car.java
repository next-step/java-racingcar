package step3;



public class Car {

    private final String CAR_STATE_BAR = "-";
    private Integer curMove = 0;
    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }


    public int move(int num){
        if(num < 0 || 9 < num) {
            throw new IllegalArgumentException();
        }

        if(movableStrategy.canMove(num)){
            curMove += 1;
        }

        return curMove;
    }

    public String getCurMoveStateExp(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curMove; i++) {
            sb.append(CAR_STATE_BAR);
        }
        return sb.toString();
    }

    public Boolean checkPosition(Integer pos){
        return pos.equals(curMove);
    }

    @Override
    public String toString(){
        return String.valueOf(curMove);
    }
}
