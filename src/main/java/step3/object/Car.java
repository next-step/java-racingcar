package step3.object;

public class Car {
    private static final int MIN_AVAILABLE_CHANCE = 4;

    private int position = 1;

    public void move(int chance) {
        if (chance >= MIN_AVAILABLE_CHANCE){
            this.position++;
        }
    }
    public int getPosition() {
        return position;
    }
}
