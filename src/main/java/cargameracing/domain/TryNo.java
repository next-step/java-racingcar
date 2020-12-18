package cargameracing.domain;

public class TryNo {
    private int tryNo;

    public TryNo(int tryNo) {
        this.tryNo = tryNo;
    }

    public boolean racing() {
        race();
        return this.tryNo >= 0;
    }

    public void race() {
        this.tryNo -= 1;
    }
}
