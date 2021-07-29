package step5.domain;

public class CarEngine {

    private static final Integer LIMIT_RPM = 3;

    public boolean canMove(int rpm) {
        return rpm > LIMIT_RPM;
    }
}
