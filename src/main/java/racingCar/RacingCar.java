package racingCar;

import java.util.Random;

public class RacingCar {
    private int pos;

    public RacingCar(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "RacingCar{" + "pos=" + pos + '}';
    }

    int makeRandomNum() {
        return new Random().nextInt(10);
    }

    void progress() {
        if (makeRandomNum() >= 4){
            incPos();
        }
    }

    protected void incPos() {
        ++this.pos;
    }
}
