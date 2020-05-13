package racinggame.domain.support;

import racinggame.domain.Engine;

public class TestSwitchEngine implements Engine {
    private boolean flag;

    public TestSwitchEngine(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean isMovable() {
        flag = !flag;
        return !flag;
    }
}
