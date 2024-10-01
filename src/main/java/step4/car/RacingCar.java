package step4.car;

public class RacingCar implements CarStrategy {

    private final static int FORWARD_DISTANCE = 1; //전진하는 거리

    private final String carName; //자동차이름
    private int distance = 0; //현재 전진한 거리

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public RacingCar(String carName, int distance) {
        this.carName = carName;
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

    @Override
    public String getCarName() {
        return this.carName;
    }

    //객체를 복사한다.
    @Override
    public CarStrategy copy() {
        return new RacingCar(this.carName, this.distance);
    }

}