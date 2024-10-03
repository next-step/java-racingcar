package racingCar.step4;

public class RacingCar {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;

    private final String name;

    private int position;

    private RacingCar(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다");
        }
        this.name = name;
    }

    public static RacingCar createCarWithName(String name) {
        return new RacingCar(name);
    }

    public void move(int moveCondition){
        if(isMoveable(moveCondition)) this.position++;
    }

    public boolean isCurrentPosition(int position) {
        return this.position == position;
    }

    private boolean isMoveable(int moveCondition) {
        return moveCondition >= MINIMUM_MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
