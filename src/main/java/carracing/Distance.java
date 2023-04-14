package carracing;

public class Distance {
    private int distance;

    public Distance() {
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void plus() {
        this.distance += 1;
    }

    public String toDash() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }
}
