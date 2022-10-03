package step3.car_racing.view;

import step3.car_racing.service.Racing;

public class ResultView {

    public void result(InputView input) {

        System.out.println();

        System.out.println("실행결과");

        new Racing().race(input);
    }


}
