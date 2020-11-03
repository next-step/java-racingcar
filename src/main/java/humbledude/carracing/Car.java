package humbledude.carracing;

public class Car {

    private int position = 0;

    public void accelerate(int fuel) {
        if (fuel >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
