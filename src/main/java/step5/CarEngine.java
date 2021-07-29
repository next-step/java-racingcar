package step5;

public class CarEngine {

    private static final Integer LIMIT_RPM = 3;

    public boolean canMove(int rpm) {
        return rpm > LIMIT_RPM;
    }
}
