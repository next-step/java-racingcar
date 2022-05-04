package racing.domain;

public class CurPositionResult {
    private int position;
    private String name;

    public CurPositionResult(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public static CurPositionResult of(Car car){
        return new CurPositionResult(car.getCurPosition(), car.getName());
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
