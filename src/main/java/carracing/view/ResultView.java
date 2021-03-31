package carracing.view;

import carracing.vo.Car;


public class ResultView {

    public static void print(Car car) {
        car.getRacingResult().forEach(System.out::println);

        System.out.println();
    }

}
