package racinggame.domain;

public class TryNo {
    private int tryNo;

    public TryNo(int tryNo) {
        this.tryNo = tryNo;
    }

    public void race() {
        this.tryNo--;
    }

    public boolean racing() {
        return tryNo > 0;
    }
}
