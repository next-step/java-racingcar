package racing.view;

import racing.dto.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 기능 1. dash print
 *  > int를 받아올 것인가, Car 객체를 받아올 것인가?
 */
public class ResultView {

    public  static void gameResult(List<Car> cars){

        for(Car c : cars){
            System.out.print(c.getName() + " : ");
            System.out.println(getDashs(c.getPosition()));
        }
        System.out.println();
    }

    private static String getDashs(int position){

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< position; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    public static void getWinnersList(List<Car> cars){
        String winnersList = cars.stream()
                                .map(car -> car.getName())
                                .collect(Collectors.joining(","));

        System.out.println(winnersList + " 가 최종 우승하였습니다.");

    }

}
