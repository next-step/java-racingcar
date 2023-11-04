package study.racingcar;

public class Car {

    private final RandomGenerator randomGenerator;
    private MoveStatus moveStatus;

    private static final int MOVE_CONDITION = 4;

    public Car(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        if (pickRandomValue()>=4){
            moveStatus = MoveStatus.MOVE;
            return;
        }
        moveStatus = MoveStatus.STOP;
    }

    private int pickRandomValue() {
        return randomGenerator.number();
    }

    public MoveStatus moveStatus(){
        return moveStatus;
    }
}
