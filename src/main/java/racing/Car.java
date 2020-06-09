package racing;

public class Car {

    private final static int MINIMUM_CONDITIONS = 4;

    private int position;
    private String carName;

    public Car(String inputCarName) {
        this(inputCarName, 0);
    }

    public Car(String inputCarName, int position) {

        if(inputCarName.trim().isEmpty()){
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        if(position < 0){
            throw new IllegalArgumentException("위치값이 0보다 작을 수 없습니다.");
        }

        this.carName = inputCarName;
        this.position = position;
    }

    private void decidePosition(boolean greaterCheck) {
        if (greaterCheck) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public void move(int number) {
        decidePosition(number >= MINIMUM_CONDITIONS ? true : false);
    }

    public boolean isSamePosition(Integer inputposition) {
        return position == inputposition;
    }

}
