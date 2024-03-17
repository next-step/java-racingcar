package step3;

public class Car {

    int position = 0;

    public int getPosition() {
        return position;
    }

    public Car() {
    }
    public RaceResultMap move(boolean attemptResult) {
        if (attemptResult) {
            position += 1;
        }
        return new RaceResultMap(position);
    }
}
