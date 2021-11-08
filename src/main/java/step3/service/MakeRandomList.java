package step3.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class MakeRandomList {

    public ArrayList<Integer> makeRandomList(int size){

        Random random = new Random();
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            randomList.add(random.nextInt(10));
        }
        return randomList;
    }
}
