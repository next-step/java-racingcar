package car_racing.domain.model;

public class Car {
    private final String name;
    private final RaceResult raceResult = new RaceResult();
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(int distance) {
        if (distance < 0) throw new IllegalArgumentException("자동차는 음수만큼 움직일 수 없습니다.");
        this.distance += distance;
        this.raceResult.addRecord(this.distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public RaceResult getRaceResult() {
        return raceResult;
    }
}
