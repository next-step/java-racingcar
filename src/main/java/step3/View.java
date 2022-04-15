package step3;

import java.util.List;

public class View {


    public void printRaceResult(Cars cars){
        List<String> curMoveStateExps = cars.getCurMoveStateExps();
        for(String bar: curMoveStateExps){
            System.out.println(bar);
        }
        System.out.println();
    }


}
