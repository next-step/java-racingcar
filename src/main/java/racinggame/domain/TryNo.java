package racinggame.domain;

public class TryNo {
    private final int tryNo;

    public TryNo(int tryNo) {
        this.tryNo = tryNo;
    }

    public TryNo race() {
        return new TryNo(tryNo - 1);
    }
}
