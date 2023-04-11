package step3;

public class Car {

    private final StringBuilder sb = new StringBuilder();

    public void move(int input) {
        if (input <= 3) {
            return;
        }
        sb.append("-");
    }

    public String getDistance() {
        return sb.toString();
    }
}
