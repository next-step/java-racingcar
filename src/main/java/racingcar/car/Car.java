package racingcar.car;

public class Car implements Comparable<Car> {

    private String name;
    private int position;
    private PowerGenerator powerGenerator;

    @Override
    public int compareTo(Car o) {
        //내림차순
        if (this.position < o.position) {
            return 1;
        }

        if(this.position == o.position) {
            return 0;
        }

        return -1;
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

    public boolean isWinner(int position) {
        if(this.position == position) return true;

        return false;
    }
}
