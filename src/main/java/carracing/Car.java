package carracing;

import static carracing.CarUtil.getRandomNumber;

public class Car {
    public int distance = 0;

    public void move() {
        int randomNum = getRandomNumber();
        getMove(randomNum);
    }

    public void getMove(int randomNum) {
        if (randomNum > 3) {
            distance++;
        }
    }


}