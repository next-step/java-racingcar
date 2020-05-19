package racingcar;

public class CarPosition implements Comparable<CarPosition> {

    private String name;
    private int position;

    public CarPosition(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(CarPosition o) {
        return Integer.compare(o.position, position);
    }
}
