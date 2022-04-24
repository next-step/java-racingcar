package carrace;

public class Car {

    private final RandomMoving randomMoving = new RandomMoving();

    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void race() {
        this.position += move(randomMoving);
    }

    public void race(int numberOfRaces) {
        for (int i = 0; i < numberOfRaces; i++) {
            this.position += move(randomMoving);
        }
    }

    private int move(RandomMoving randomMoving) {
        return randomMoving.move(randomMoving.isMove());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
