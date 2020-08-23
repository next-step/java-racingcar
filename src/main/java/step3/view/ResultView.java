package step3.view;

import step3.Car;

import java.util.List;
import java.util.Map;


public class ResultView {

    public void showResultIntro(){
        System.out.println("실행결과");
    }

    public void showRacingResult(Map<Car, List<Integer>> map, int tryCount){
        for(int i = 0; i < tryCount; i++){
            final int index = i;
            map.forEach((k, v) -> showPosition(k, v.get(index)));
            System.out.println("");
        }
    }

    public void showWinners(List<String> winners){
        StringBuilder names = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            names.append(addCommaToName(winners.get(i), i, winners.size() - 1));
        }

        System.out.println(names + "가 최종 우승했습니다.");
    }

    private String addCommaToName(String name, int index, int size){
        return index != size ? name + "," : name;
    }

    private void showPosition(Car car, int position){
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < position; i++){
            System.out.print("-");
        }
        System.out.println("");

    }

}