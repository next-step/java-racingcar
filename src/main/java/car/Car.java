package car;

import car.Impl.MoveOver;
import car.Impl.MoveRandem;

import java.util.Map;
import java.util.Random;

public class Car {



    public int goStop(int randemValue){
        if(randemValue > 3){
            return 1;
        }
        return 0;
    }

    public int[] createIntArray(int count){
        return new int[count];

    }

}
