package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import camp.nextstep.edu.rebellion.racing.util.StringUtil;

public class RacingCar implements Cloneable {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public RacingCar(String name){
        validateName(name);
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

    private void validateName(String name) {
        if(StringUtil.isEmpty(name) || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름이 최대 길이를 초과했습니다 "
                    + name.length());
        }
    }
}
