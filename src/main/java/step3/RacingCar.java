package step3;

import java.util.Random;

class RacingCar {

    private int successCount;
    private Random random = new Random();

    int getSuccessCount(){
        return successCount;
    }

    void tryMoveForward(){
        if(4 <= random.nextInt(10)){
            successCount++;
        }
    }

}
