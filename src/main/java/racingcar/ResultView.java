package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class ResultView {
    public void print(List<Cars> result){

        for(Cars cars: result){
            for(Car c: cars.getCars()){

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
