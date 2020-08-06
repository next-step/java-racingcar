package racingcar.domain.rule;

public interface MotorRacingRule {
    boolean pass();
    static MotorRacingRule defaultMoveRule(){
        return new MotorRacingRandomMoveRule();
    }
}
