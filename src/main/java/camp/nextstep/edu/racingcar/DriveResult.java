package camp.nextstep.edu.racingcar;

public class DriveResult {

    private final int drives;

    public DriveResult(int drives) {
        this.drives = drives;
    }

    @Override
    public String toString() {
        return "-".repeat(drives);
    }
}
