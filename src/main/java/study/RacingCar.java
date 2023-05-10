package study;

import java.util.Random;

public class RacingCar {

    private int position = 0;

    public int position() { // getPosition의 getter이름이 아닐 뿐이지, 캡슐화를 위배하는 것은 똑같지 않나요..?
        return this.position;
    }

    public void moveForwardWhenFourHigher(Random random) {
        if (random.nextInt(10) >= 4) {
            move();
        }
    }

    private void move() {
        position++;
    }
}
