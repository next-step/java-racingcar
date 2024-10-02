package step3.car;

public class RacingCar implements CarStrategy {

    private final static int FORWARD_DISTANCE = 1; //전진하는 거리

    private int distance = 0; //현재 전진한 거리

    public RacingCar() {
    }

    public RacingCar(int distance) {
        this.distance = distance;
    }

    //차를 전진한다.
    @Override
    public void forward() {
        this.distance += FORWARD_DISTANCE;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    //객체를 복사한다.
    @Override
    public CarStrategy copy() {
        return new RacingCar(this.distance);
    }

}