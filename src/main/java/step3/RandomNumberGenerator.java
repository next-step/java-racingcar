package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static int BOUND = 10;
    private static Random random = new Random();

    public static int getRandomInt(){
        return random.nextInt(BOUND);
    }

    public static List<Integer> getRandomIntList(int cnt){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            list.add(getRandomInt());
        }
        return list;
    }
}
