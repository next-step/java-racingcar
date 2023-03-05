package car.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public String printStatus() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void increasePosition() {
        this.position++;
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return this.position;
    }
}
