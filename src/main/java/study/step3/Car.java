package study.step3;

<<<<<<< HEAD
public class Car {
    private final static int INIT_ZERO = 0;
    private final static int INT_ONE = 1;
    private final int carPosition;

    public Car() {
        this.carPosition = INIT_ZERO;
    }

    public Car(int carPosition) {
        this.carPosition = carPosition;
    }

    public Car move(CarMoveCondition moveCondition){
        if (moveCondition.isCarMoveCondition()){
            return new Car(increasecarPosition());
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static final int INIT_INDEX = 0;
    private static final int GO_CONDITION_LIMIT_NUMBER = 4;
    private static RandomGenerator random = new RacingRandomGenerator();

    private String carName ="";
    private int carPosition = 0;

    private List<Integer> carPositions;

    public Car(String carName) {
        this.carName = carName;
        carPositions = new ArrayList<>();
    }

    public Car move(int moveTime){
        for (int i = INIT_INDEX; i < moveTime; i++){
            if (goOrStop(random.getRandomInt()) && i > 0){
                this.carPosition++;
            }
            carPositions.add(carPosition);
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
        }
        return this;
    }

<<<<<<< HEAD
    public int getCarPosition(){
        return carPosition;
    }

    private int increasecarPosition() {
        return carPosition + INT_ONE;
    }
=======
    public String carNameToString() {
        return "["+carName +"]번 차";
    }

    public int nowCarPostion(){
        return this.carPosition;
    }

    public Integer pointInTimeCarPostion(int round){
        return carPositions.get(round);
    }

    public int rounds(){
        return carPositions.size();
    }

    public boolean goOrStop(int randomNumber){
        return randomNumber >=  GO_CONDITION_LIMIT_NUMBER;
    }

>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
}
