package study.racingcar.car;

public class CarSnapshotExporter implements CarExporter<CarSnapshot>{

    private String name;
    private int currentPosition;

    public CarSnapshotExporter() {}

    @Override
    public void name(String name) { this.name = name; }

    @Override
    public void currentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public CarSnapshot build() {
        return new CarSnapshot(name, currentPosition);
    }

}
