package step3;

import java.util.Random;

public class Car {

    private int count=0;

    public void move(){
        int number = new Random().nextInt(10);
        if(4 < number){
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
