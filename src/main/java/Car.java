public class Car {
    private int numberOfAdvances;

    public Car(int numberOfAdvances) {
        this.numberOfAdvances = numberOfAdvances;
    }

    public void advance() {
        numberOfAdvances--;
    }
}
