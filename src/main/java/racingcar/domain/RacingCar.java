package racingcar.domain;

public class RacingCar implements CarInterface {
    private int position;       // 차가 이동한 위치

    public RacingCar() {
        this.position = POSITION;
    }

    @Override
    public void move() {
        RandomNumber randomNumber = new RandomNumber();

        if(randomNumber.calculateRandomNumber() >= CAR_MOVEMENT_STANDARD_POINT) {
            this.position += MOVEMENT_DISTANCE;
        }
    }

    @Override
    public int position() {
        return this.position;
    }
}
