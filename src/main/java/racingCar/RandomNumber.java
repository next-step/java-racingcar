package racingCar;


public class RandomNumber {
    public static final int ROUNDUP_NUMBER = 10;
    public static final int MOVE_CRITERIA = 4;

    private int randomNumber;

    public RandomNumber(){
        this.randomNumber = (int) (Math.random()*ROUNDUP_NUMBER);
    }

    public boolean validateRandomNumber() {
        return 0<=this.randomNumber && this.randomNumber <=9;
    }
    
    public boolean canMovePosition(){
        return (this.randomNumber>=MOVE_CRITERIA);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
