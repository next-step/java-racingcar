package Step3;

public class RacingCar {
    private int pos;

    public RacingCar() {
        this.pos = 0;
    }

    public int getPos() {
        return this.pos;
    }

    public int move(int rand) {
        if (rand < 4) {
            return this.pos;
        }

        this.pos += 1;

        return this.pos;
    }
}
