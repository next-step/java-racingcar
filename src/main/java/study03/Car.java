package study03;

import java.util.Random;

/*
*
* Car
*
* @version 1.0.0
*
* 2021-11-07
*
* Copyright tnals1422
*/
public class Car {


    public void play() {
        int condition = createConditionNumber();
    }

    public int createConditionNumber() {
        return new Random().nextInt(10);
    }
}
