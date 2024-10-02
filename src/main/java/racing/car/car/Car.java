package racing.car.car;

public class Car implements Movable {

    private String name;
    private int position;
    private static final int MOVE_THRESHOLD = 4;

    public Car(){
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void move(int number) {
        if (isMoveAllowed(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isMoveAllowed(int number) {
        return number >= MOVE_THRESHOLD;
    }

}
