package step3;

import java.util.Random;

class Forward {

    private Random random = new Random();

    boolean tryMove(){
        return 4 <= random.nextInt(10);
    }

}
