package step3.view;

import step3.Car;
import step3.Constant;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void showResultIntro(){
        System.out.println(Constant.RACING_RESULT);
    }

    public void showRacingResult(Map<Car, List<Integer>> map, int tryCount){
        for(int i = 0; i < tryCount; i++){
            final int index = i;
            map.forEach((k, v) -> showPosition(k, v.get(index)));
            System.out.println("");
        }
    }

    public void showWinners(List<String> winners) {
        String names = String.join(",", winners);
        System.out.println(names + Constant.RACING_RESULT_ANNOUNCEMENT);
    }

    private void showPosition(Car car, int position){
        System.out.print(car.getName() + Constant.CAR_NAME_BORDER);
        for(int i = 0; i < position; i++){
            System.out.print(Constant.CAR_POSITION_UNIT);
        }
        System.out.println("");

    }

}