package racing;

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

    public void printGameResult(Cars cars){
        List<String> nameList = cars.getWinners();
        String winners = String.join(",", nameList);
        System.out.println(winners+"가 최종 우승했습니다.");
    }

}
