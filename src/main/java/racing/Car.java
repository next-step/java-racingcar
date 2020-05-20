package racing;

public class Car {
    public int carNumber;
    public int position;

    Car(int carNumber, int position) {
        this.carNumber = carNumber;
        this.position = position;
    }

    public int move(int random) {
        if (random >= 4) {
            this.position = this.position + 1;
        }
        return this.position;
    }
}
