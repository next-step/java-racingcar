package rcgame.dto;

public class RcGameRequest {
    private String[] rcCarName;
    private int time;

    public RcGameRequest(String[] rcCarName, int time) {
        this.rcCarName = rcCarName;
        this.time = time;
    }

    public String[] getRcCarName() {
        return rcCarName;
    }

    public int getTime() {
        return time;
    }
}
