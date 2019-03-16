package racingcar.domain.car;

public class Car implements Comparable<Car> {

    private String name;
    private int position = 0;
    private PowerGenerator powerGenerator;

    @Override
    public int compareTo(Car o) {
        //A compare To B, 순차정렬
        return Integer.compare(this.position, o.position);
    }

    public Car(String name) {
        this.name = name;
        this.powerGenerator = new PowerGenerator();
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        this.powerGenerator = new PowerGenerator();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        position += powerGenerator.determineMoveOrNot();
        return position;
    }
}
