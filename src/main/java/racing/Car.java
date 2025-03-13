package racing;

public class Car {

    int position;

    public Car() {
        this.position = 1;
    }

    public int active(boolean canProgress) {
        if (canProgress) {
            this.position++;
        }
        return this.position;
    }

}
