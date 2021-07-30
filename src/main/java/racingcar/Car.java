package racingcar;

public class Car {
정    private int position = 1;

    public int getPosition() {
        return position;
    }

    public void move() {
         if(Math.random() * 10 >= moveCount) {
             position ++;
         }
    }
}
