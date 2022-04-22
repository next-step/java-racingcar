package racingCar;

public class Car {

    private Position position;

    public Car(){
        this.position = new Position();
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public Position currentPosition(){
        return this.position;
    }
    /*
    public void move(RandomNumber randomNumber){
        if (randomNumber.canMovePosition()){
            this.position.increase();
        }
    }
     */

    public void move(int number){
        if (number>=RandomNumber.MOVE_CRITERIA){
            this.position.increase();
        }
    }
}
