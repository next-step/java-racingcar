package race;

public class FixedStay implements ForwardCheck {
    @Override
    public boolean isForward() {
        return false;
    }
}
