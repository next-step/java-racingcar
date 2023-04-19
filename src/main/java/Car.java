public class Car {

    private StringBuilder mark;

    public Car() {
        mark = new StringBuilder();
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
