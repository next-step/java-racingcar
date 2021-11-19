package step3;

import java.util.Random;

public class RacingCar {
    int distance = 0;

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isMove(int randomNumber) {
        // randomNumber가 primitive type 인데
        // 클래스로 바꾸어 reference type 으로 변경이 필요할지?
        if(randomNumber > 4) {
            return true;
        }
        return false;
    }

    public void move() {
        distance++;
    }


}
