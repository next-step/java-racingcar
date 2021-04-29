package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class MoveService {
    @Test
    public String isMove(){
        Random random = new Random();
        int number = random.nextInt(10);
        if(number>=4){
            return "1";
        }
        return "0";
    }
}
