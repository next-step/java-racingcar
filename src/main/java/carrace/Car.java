package carrace;

public class Car {


    private final RandomMoving randomMoving = new RandomMoving();

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int race(int numberOfRaces) {
        int result = 0;
        for (int i = 0; i < numberOfRaces; i++) {
            result += move(randomMoving);
        }

        return result;
    }

    private int move(RandomMoving randomMoving) {
        return randomMoving.move(randomMoving.isMove());
    }

    public String getName() {
        return name;
    }
}
