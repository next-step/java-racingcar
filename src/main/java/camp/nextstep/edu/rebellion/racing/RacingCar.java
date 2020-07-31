package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

public class RacingCar {
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

    public int getPosition() {
        return this.position;
    }
}
