package step3.car_racing.view;

import step3.car_racing.service.Racing;

public class ResultView {

    public void result(InputView inputView) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carSize = inputView.input();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = inputView.input();

        System.out.println();

        System.out.println("실행결과");

        new Racing().race(carSize, racingCount);
    }


}
