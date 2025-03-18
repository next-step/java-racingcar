package car_racing.domain.model;

public class Car {
    private static final String RACE_RESULT_DELIMITER = " : ";

    private final Name name;
    private final RaceResult raceResult = new RaceResult();
    private Integer distance;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int distance) {
        if (distance < 0) throw new IllegalArgumentException("자동차는 음수만큼 움직일 수 없습니다.");
        this.distance += distance;
        this.raceResult.addRecord(this.distance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return distance;
    }

    public String getRaceResultOfRound(int round) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name.getName())
                .append(RACE_RESULT_DELIMITER)
                .append(raceResult.getPositionOfNthRound(round));
        return sb.toString();
    }

}
