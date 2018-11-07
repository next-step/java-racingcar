package racing.view;

import racing.dto.Car;

import java.util.List;

/**
 * 기능 1. dash print
 *  > int를 받아올 것인가, Car 객체를 받아올 것인가?
 */
public class ResultView {

    public void gameResult(List<Car> cars){

        for(Car c : cars){
            System.out.println(getDashs(c.getPosition()));
        }
        System.out.println();
    }

    public String getDashs(int position){

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< position; i++){
            sb.append("-");
        }
        return sb.toString();
    }


}
