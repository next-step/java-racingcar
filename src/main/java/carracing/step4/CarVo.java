package carracing.step4;

public class CarVo {
    private final String name;
    private final int moveCount;

    public CarVo(Car car) {
        this.name = car.getName();
        this.moveCount = car.getMoveCount();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
