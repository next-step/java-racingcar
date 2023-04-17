package step4.model;

public class Record {
    private String player;
    private int distance;

    public Record(String player, int distance) {
        this.player = player;
        this.distance = distance;
    }

    public String getPlayer() {
        return player;
    }

    public int getDistance() {
        return distance;
    }
}
