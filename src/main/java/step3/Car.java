package step3;

public class Car {
    private int position = 0;

    public void setPosition(boolean greaterCheck) {
        if (greaterCheck) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public int getRandomNumber() {
        return Dice.makeRandomNumber();
    }

    public boolean isGreater(int number) {
        return number > 4 ? true : false;
    }

}
