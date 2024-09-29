package racingcar.model;

public class Car {

    private int position;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public void stop() {

    }

    public String showStatus() {
        StringBuilder status = new StringBuilder();
        for (int cnt = 0; cnt < position; ++cnt) {
            status.append("-");
        }
        return status.toString();
    }
}
