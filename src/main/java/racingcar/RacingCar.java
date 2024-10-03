package racingcar;

public class RacingCar {
    private int carNo;
    private int position;

    static int INITIAL_POSITION =  0;

    public RacingCar(int carNo) {
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public void race() {

    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
