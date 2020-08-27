package step3;

import java.util.Random;

class Forward implements CarMovement {

    private Random random = new Random();

    @Override
    public boolean isSuccess() {
        return Constant.FORWARD_MIN <= random.nextInt(Constant.FORWARD_MAX);
    }

}
