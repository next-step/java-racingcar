package step3.view;

import step3.Car;

import java.util.List;
import java.util.Map;


public class ResultView {

    public void startResult(){
        System.out.println("실행결과");
    }

    public void showRacingResult(Map<Car, List<Integer>> map, int tryCount){

        for(int i = 0; i < tryCount; i++){
            final int index = i;
            map.forEach((k, v) -> showPosition(v.get(index)));
            System.out.println("");
        }

    }


    private void showPosition(int position){

        for(int i = 0; i < position; i++){
            System.out.print("-");
        }
        System.out.println("");

    }

}