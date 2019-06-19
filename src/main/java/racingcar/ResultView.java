package racingcar;

import racingcar.model.Car;

import java.util.List;

public class ResultView {
    public void print(List<List<Car>> result){

        for(List<Car> lc: result){
            for(Car c: lc){

                StringBuilder sb = new StringBuilder();
                for(int count = 0; count < c.getPosition(); count ++) {
                    sb.append("-");
                }
                System.out.println(sb.toString());

            }
            System.out.println();

        }
    }
}
