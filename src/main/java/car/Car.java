package car;

import java.util.Random;

public abstract class Car {
    Random random = new Random();
    private int position = 0;

    public int goStop(){
        if(move() > 3){
            return position += 1;
        }
        return position;
    }

    public abstract int move();




}
