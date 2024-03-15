public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void decideMove(int randomNum) {
        if (randomNum > 3) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
