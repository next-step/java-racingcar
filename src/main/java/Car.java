public class Car {

    private int number;
    private StringBuilder mark;

    public Car() {
        mark = new StringBuilder();
    }

    public Car(int number) {
        mark = new StringBuilder();
        this.number = number;
    }

    public void move() {
        move(number);
    }

    public void move(int number) {
        final int MINIMUM = 4;

        if (number >= MINIMUM) {
            mark.append("-");
        }
    }

    public String print() {
        return this.mark.toString();
    }
}
