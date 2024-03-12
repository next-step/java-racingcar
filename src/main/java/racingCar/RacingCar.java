package racingCar;

public class RacingCar {
    private int position;

    public RacingCar(){
        this.position = 0;
    }

    public int positionOfRacingCar(){
        return this.position;
    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.isMove()){
            this.position++;
        }
    }
}
