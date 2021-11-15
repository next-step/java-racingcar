package study04;

public class RacingCar {

    private final String name;
    private final Engine engine;
    private final Distance moveDistance;

    private RacingCar(String name, Engine engine, Distance moveDistance) {
        this.name = name;
        this.engine = engine;
        this.moveDistance = moveDistance;
    }

    public static RacingCar createRacingCar(String name) {
        return createRacingCar(name, Engine.createEngine(), Distance.createDistance());
    }

    public static RacingCar createRacingCar(String name, Engine engine, Distance moveDistance) {
        return new RacingCar(name, engine, moveDistance);
    }

    public void move() {
        if (engine.isRun()) {
            this.moveDistance.addDistance();
        }
    }

    public int currentMoveDistance() {
        return moveDistance.totalDistance();
    }

    @Override
    public String toString() {
        return String.format("[%s] 자동차 (주행거리:%s)", name, currentMoveDistance());
    }

}
