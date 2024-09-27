package car;

public class RacingCar {

    private final static int FORWARD_DISTANCE = 1; //전진하는 거리
    private final static int FORWARD_STANDARD = 4; //전진여부를 결정하는 기준

    private int distance = 0; //현재 전진한 거리

    //입력받은 값이 4이상일시 차를 전진한다.
    public void forward(int num) {
        if (num >= FORWARD_STANDARD) {
            this.distance += FORWARD_DISTANCE;
        }
    }

    public int getDistance() {
        return distance;
    }

    public void result() {
        System.out.println("-".repeat(distance));
    }
}