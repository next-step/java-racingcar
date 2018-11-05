package racingGame;

public class Car implements Comparable<Car> {

    private static final int MINIMUM_MOVABLE_SCORE = 4;

    private int position;
    private String name;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public void moveForward(int score) {
        if (canMove(score)) {
            position++;
        }
    }

    public int getCurrentPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    private boolean canMove(int score) {
        return score >= MINIMUM_MOVABLE_SCORE;
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.getCurrentPosition());
    }

    @Override
    public String toString() {
        return name + " : " + new String(new char[position]).replace("\0", "-");
    }
}
