package car;

import java.util.Random;

public class Car {
    Random random = new Random();
    private int position = 0;

    public void move(int moveStrategy){
        if(moveStrategy > 3) {
            position += 1;
        }
    }
    public int getPosition(){
        return this.position;
    }

    public int randomMoveStrategy(){
        return random.nextInt(10);
    }

    public int stopMoveStrategy(){
        return random.nextInt(4);
    }

    public int goMoveStrategy(){
        return random.nextInt(6)+4;
    }





}
