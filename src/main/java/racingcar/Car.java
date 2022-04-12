package racingcar;

public class Car {
    private int distance = 0;
    private final StringBuilder sb = new StringBuilder();

    public boolean isMove(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            distance += 1;
            sb.append("-");
            return true;
        }
        return false;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getShowDistance(){
        return sb.toString();
    }
}
