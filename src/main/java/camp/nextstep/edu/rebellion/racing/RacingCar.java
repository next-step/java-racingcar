package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

public class RacingCar implements Cloneable {
    private final String name;
    private int position;

    public RacingCar(String name){
        this.name = name;
    }

    public void move(RacingRule rule) {
        if (rule.pass()) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public RacingCar clone() {
        try {
            return (RacingCar) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("자동차 객체를 복사하는데 실패하였습니다");
        }
    }
}
