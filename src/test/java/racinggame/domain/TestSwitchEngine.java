package racinggame.domain;

public class TestSwitchEngine implements Engine {
    private boolean flag = false;

    @Override
    public boolean isMovable() {
        flag = !flag;
        return flag;
    }
}
