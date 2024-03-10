package step3;

public class RaceResultMap {
    String name;
    int position;

    public RaceResultMap(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "-".repeat(position + 1);
    }
}
