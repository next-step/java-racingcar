package study.step4.try3.domain;

public class Car {
    private static final int MOVE_NUMBER = 4;

    private final String carName;
    private int position;
    private final MoveRecord moveRecord;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
        this.moveRecord = new MoveRecord();
    }

    public static Car of(String carName, int position) {
        return new Car(carName, position);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.position++;
        }
        this.moveRecord.save(this.position);
    }

    public void print(int round) {
        this.moveRecord.print(this.carName, round);
    }
}
