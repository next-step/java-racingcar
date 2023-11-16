package camp.nextstep.edu.racingcar.domain.result;

public class DriveResult {

    public final String name;
    public final int drivenDistance;

    public DriveResult(String name, int drivenDistance) {
        this.name = name;
        this.drivenDistance = drivenDistance;
    }

    public String name() {
        return this.name;
    }

    public int drivenDistance() {
        return this.drivenDistance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(drivenDistance);
    }
}
