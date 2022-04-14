package study.step3;

public class Car {
    private int position;

    public int getPosition() {
        return position;
    }

    public void move(int condition) {
        if (condition >= 4) {
            position++;
        }
    }
}
