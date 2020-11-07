package study.racingcar.car;

public class CarSnapshotExporter implements CarExporter<CarSnapshot>{

    private CarSnapshot carSnapshot;

    public CarSnapshotExporter() {
        this.carSnapshot = new CarSnapshot();
    }

    @Override
    public void name(String name) { carSnapshot.setName(name); }

    @Override
    public void currentPosition(int currentPosition) {
        carSnapshot.setCurrentPosition(currentPosition);
    }

    @Override
    public CarSnapshot build() {
        return carSnapshot;
    }

}
