package step3.service;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MoveOrStop {
    private ArrayList<String> inputCarList;

    public MoveOrStop() {
    }

    public ArrayList<String> moveOrStop(ArrayList<String> inputCarList, ArrayList<Integer> randomList) {

        ArrayList<String> resultList = new ArrayList<String>();
        AtomicInteger index = new AtomicInteger();
        randomList.stream().forEach((i)-> {
            if (i <= 4) {
                resultList.add(inputCarList.get(index.getAndIncrement()));
            } else {
                resultList.add(inputCarList.get(index.getAndIncrement())+("-"));
            }});
        return resultList  ;
    }
}
