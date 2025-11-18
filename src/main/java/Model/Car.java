package Model;

public class Car {
    private int position;

    Car(int position) {
        this.position = position;
    }

    public boolean canMoveForward(int randomNumber) {
        return randomNumber >= 4;
    }

    public void tryMoveForward(int randomNumber) {
        if (canMoveForward(randomNumber)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
