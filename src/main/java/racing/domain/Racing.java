package racing.domain;

public class Racing {

    private boolean[] result;

    public Racing(boolean[] result) {
        this.result = result;
    }
    public int getResultLength() {
        return result.length;
    }

    public boolean getDetailResult(int car) {
        return result[car];
    }

}
