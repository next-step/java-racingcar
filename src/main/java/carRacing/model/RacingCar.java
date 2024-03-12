package carRacing.model;

public class RacingCar {

    private int position;

    public RacingCar() {

        this.position = 0;
    }

    public int positionOfRacingCar() {

        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMove()){
            this.position++;
        }
    }
}
