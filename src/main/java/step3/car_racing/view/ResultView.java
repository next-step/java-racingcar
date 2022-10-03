package step3.car_racing.view;

import step3.car_racing.service.Racing;

public class ResultView {

    public void result(InputView inputView) {

        int carSize = inputView.inputCarSize();

        int racingCount = inputView.inputRacingSize();

        System.out.println();

        System.out.println("실행결과");

        new Racing().race(carSize, racingCount);
    }


}
