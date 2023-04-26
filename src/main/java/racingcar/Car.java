package racingcar;

public class Car implements Comparable<Car>{
    private MoveStrategy moveStrategy;
    private String name;
    private int position = 0;

    public Car(MoveStrategy moveStrategy, String name) {
        validateName(name);
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void tryMove() {
        move(moveStrategy.isMovable());
    }

    private void move(boolean isMovable) {
        if (isMovable) {
            increasePosition();
        }
    }

    private void increasePosition() {
        this.position += 1;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format("Length of the car name %s has exceeded 5.", name));
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }

    public boolean isAt(int position){
        return this.position == position;
    }
}
