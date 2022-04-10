package racing;

public class Car {

    private static final String INVALID_START_CAR_POSITION = "자동차의 시작점은 0이상 이어야합니다.";
    private int position;

    public Car(int position) {
        validateCarPosition(position);
        this.position = position;
    }

    private void validateCarPosition(int position) {
        if(position < 0){
            throw new IllegalArgumentException(INVALID_START_CAR_POSITION);
        }
    }

    public Car(){
        this(0);
    }

    public int currentPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position ++;
    }
}
