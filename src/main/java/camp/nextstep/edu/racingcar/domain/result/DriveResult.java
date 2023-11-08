package camp.nextstep.edu.racingcar.domain.result;

public class DriveResult {

    public final int drivenDistance;

    public DriveResult(int drivenDistance) {
        this.drivenDistance = drivenDistance;
    }

    @Override
    public String toString() {
        return "-".repeat(drivenDistance);
    }
}
