package racing.domain;

public class RacingCarRequest {

    int moveCnt;

    String names;

    public RacingCarRequest(String names, int moveCnt) {
        this.names = names;
        this.moveCnt = moveCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public String getNames() {
        return names;
    }
}
