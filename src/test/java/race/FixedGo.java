package race;

public class FixedGo implements ForwardCheck {

    private boolean isForward;

    @Override
    public boolean isForward() {
        return true;
    }
}
