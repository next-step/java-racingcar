package car;

public class RacingCar implements CarStrategy{

    private final static int FORWARD_DISTANCE = 1; //전진하는 거리
    private final static String DISTANCE_DISPLAY = "-";

    private int distance = 0; //현재 전진한 거리

    //차를 전진한다.
    @Override
    public void forward() {
        this.distance += FORWARD_DISTANCE;
    }

    @Override
    public void result() {
        System.out.println(DISTANCE_DISPLAY.repeat(distance));
    }

    @Override
    public int getDistance() {
        return distance;
    }

}