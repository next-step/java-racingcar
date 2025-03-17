package car_racing.domain.model;

public class Car {
    private int distance;
    private final RaceResult raceResult = new RaceResult();

    public void move(int distance) {
        if (distance < 0) throw new IllegalArgumentException("자동차는 음수만큼 움직일 수 없습니다.");
        this.distance += distance;
        this.raceResult.addRecord(this.distance);
    }

    public int getDistance() {
        return distance;
    }

    public RaceResult getRaceResult() {
        return this.raceResult;
    }
}
