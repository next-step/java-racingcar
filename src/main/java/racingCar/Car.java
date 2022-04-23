package racingCar;

public class Car {

    public static final int MOVE_CRITERIA = 4;

    private Position position;

    public Car(){
        this.position = new Position();
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public String makePosition(){
        return this.position.makePosition();
    }
    public void move(int randomNumber){
        if(!new RandomNumber().validateRandomNumber(randomNumber)){
            throw new IllegalStateException("randomNumber의 유효범위는 0~9입니다.");
        }

        if (canMovePosition(randomNumber)){
            this.position.increase();
        }

    }

    public boolean canMovePosition(int randomNumber){
        return (randomNumber>=MOVE_CRITERIA);
    }

    public Boolean checkPosition(int position){
        return this.position.checkPosition(position);

    }
}
