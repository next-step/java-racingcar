package game.racing;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class DefaultCar implements Car {
    private static final int THRESHOLD = 4;
    private String name;
    private int position;
    private TrackingLog trackingLog;

    public DefaultCar(String name, TrackingLog trackingLog) {
        this.name = name;
        this.trackingLog = trackingLog;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        if (CarMover.movable(THRESHOLD)) {
            position++;
        }
        trackingLog.add(position);
    }
}
