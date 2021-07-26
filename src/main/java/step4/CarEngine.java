package step4;

public class CarEngine {

    private static final Integer LIMIT_RPM = 3;

    public boolean canGo(int rpm) {
        return rpm > LIMIT_RPM;
    }
}
