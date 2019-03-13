package racingcar.car;

public class Car implements Comparable<Car> {

    private String name;
    private int position;
    private PowerGenerator powerGenerator;

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.position, this.position);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        this.powerGenerator = new PowerGenerator();
    }

    public String getName() {
        return name;
    }

    public int move() {
        position += powerGenerator.determineMoveOrNot();
        return position;
    }
}
