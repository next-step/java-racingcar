package race;

public class FixedCheckForward implements ForwardCheck {

    private boolean isForward;

    public FixedCheckForward(boolean isForward) {
        this.isForward = isForward;
    }

    @Override
    public boolean isForward() {
        return isForward;
    }
}
