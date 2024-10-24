package Step3;

public class RacingCar {
    private int pos;

    public int getPos() {
        return this.pos;
    }

    public RacingCar() {
        this.pos = 0;
    }

    public RacingCar(int pos) {
        this.pos = pos;
    }

    public void move(int rand) {
        if (rand < 4) {
            return;
        }

        this.pos++;
    }

    public void print() {
        for (int i = 0; i < this.pos; i++) {
            System.out.print("-");
        }
    }
}
