package step3;

import java.util.List;

public class View {


    public void printRaceResult(Cars cars){
        List<String> names = cars.getNames();
        List<String> curMoveStateExps = cars.getCurMoveStateExps();
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i)+" : "+curMoveStateExps.get(i));
        }
        System.out.println();
    }


}
