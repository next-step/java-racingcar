package racingcarwinner;

public class Game {

    private int roundCount;
    private final int ENABLE_MOVE_NUMBER = 4;

    private Game(){}

    public Game(int roundCount){
        this.roundCount = roundCount;
    }

    public int getRoundCount(){
        return this.roundCount;
    }

    public boolean isOrAboveEnableNumber(int randomNumber){
        return randomNumber >= this.ENABLE_MOVE_NUMBER;
    }

    public void randomMove(Car car){
        if(this.isOrAboveEnableNumber(RandomGenerator.getRandomNumber())){
            car.move();
        }
    }

    public static String[] splitCarsName(String StringCarsName){
        return StringCarsName.split(",");
    }


}
