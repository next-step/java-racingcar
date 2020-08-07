package racingcar.model;

public class RacingCar implements Cloneable {
    private String carName;
    private int carPosition;

    public RacingCar(String carName){
        this.carName = carName;
    }

    public RacingCar run(Rule racingRule) {
        if(racingRule.checkRule()) {
            carPosition++;
        }
        return this;
    }

    public RacingCar clone() {
        try {
            return (RacingCar) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("RacingCar 객체를 복사하는데 실패하였습니다.");
        }
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }
}
