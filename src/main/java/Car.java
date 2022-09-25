public class Car {

    public int currentPosition;

    public Car() {
        this.currentPosition = 0;
    }

    public void move(int randomValue) {
        if (randomValue < 0 || randomValue > 9) throw new RuntimeException("not available value");

        if (randomValue < 4) return;
        currentPosition++;
    }
}
