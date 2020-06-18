package edu.nextstep.racing;

import edu.nextstep.racing.domain.MovingCheck;

public class MovingCheckTest implements MovingCheck {
    private boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean isMovable() {
        return flag;
    }
}
