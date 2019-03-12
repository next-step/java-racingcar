package racingcar.car;

public class Car {

    private int position;
    private PowerGenerator powerGenerator;

    public Car(int position) {
        this.position = position;
        this.powerGenerator = new PowerGenerator();
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        position += powerGenerator.determineMoveOrNot();
        return position;
    }
}
