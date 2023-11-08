package camp.nextstep.edu.racingcar.domain.result;

public class DriveResult {

    private final int drivenDistance;

    public DriveResult(int drivenDistance) {
        this.drivenDistance = drivenDistance;
    }

    public int drivenDistance() {
        return this.drivenDistance;
    }

    @Override
    public String toString() {
        return "-".repeat(drivenDistance);
    }
}
