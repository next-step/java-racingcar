package racing;

public class Car {

    int position;

    public Car() {
        this.position = 0;
    }

    public int active(boolean canProgress) {
        if (canProgress) {
            this.position++;
        }
        return this.position;
    }

}
