package racinggame.domain.support;

import racinggame.domain.Engine;

public class SwitchEngine implements Engine {
    private boolean flag;

    public SwitchEngine(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean isMovable() {
        flag = !flag;
        return !flag;
    }
}
