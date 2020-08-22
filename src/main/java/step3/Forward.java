package step3;

import java.util.Random;

class Forward implements CarMovement {

    private Random random = new Random();

    @Override
    public boolean successForward() {
        return Constant.FOUR <= random.nextInt(Constant.TEN);
    }

}
