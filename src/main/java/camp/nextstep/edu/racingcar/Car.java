package camp.nextstep.edu.racingcar;

public class Car {

    private final DriveStrategy driveStrategy;
    private int drives;

    public Car(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
        this.drives = 0;
    }

    public DriveResult drive() {
        if (driveStrategy.canDrive()) {
            this.drives++;
        }
        return new DriveResult(drives);
    }
}
