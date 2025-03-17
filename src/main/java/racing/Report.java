package racing;

public class Report {

    private final int index;
    private final int position;

    public Report(int index, int position) {
        this.index = index;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
