package racing.dto;

public class RacingCarStatus implements Comparable<RacingCarStatus> {
    private String name;
    private int position;

    public RacingCarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCarStatus that) {
        return Integer.compare(this.position, that.position);
    }
}
