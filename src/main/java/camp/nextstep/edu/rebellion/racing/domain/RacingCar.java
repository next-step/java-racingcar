package camp.nextstep.edu.rebellion.racing.domain;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import camp.nextstep.edu.rebellion.racing.util.StringUtil;

public class RacingCar implements Cloneable {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    private RacingCar(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name){
        this(name, 0);
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

    public RacingCar copy() {
        return new RacingCar(this.name, this.position);
    }

    private void validateName(String name) {
        if (StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름이 최대 길이를 초과했습니다 "
                    + name.length());
        }
    }
}
