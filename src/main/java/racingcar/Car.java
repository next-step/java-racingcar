package racingcar;

import java.util.Random;

public class Car {
    private final static int FINAL_NUM = 10;
    private final static int FORWARD_NUM = 4;
    private int distance = 0;

    public boolean movable(int randomNumber) {
        if(randomNumber >= FORWARD_NUM){
            this.distance += 1;
            return true;
        }
        return false;
    }

    public boolean movable() {
        if(getRandomNumber() >= FORWARD_NUM){
            this.distance += 1;
            return true;
        }
        return false;
    }


    private int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(FINAL_NUM);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getShowDistance(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
             sb.append("-");
        }
        return sb.toString();
    }
}
