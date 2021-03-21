package carracing.view;

import carracing.vo.Car;


public class ResultView {


    public void print(Car car) {

        for (String result : car.getRacingResult())
            System.out.println(result);

        System.out.println();
    }
}
