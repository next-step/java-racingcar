package racing;

public interface CarRacingListener {

    void carMoved(int movedDistance);

    void carMovedComplete(int totalDistance);

    void racingTriedComplete();
}
