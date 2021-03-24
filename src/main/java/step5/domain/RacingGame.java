package step5.domain;

import step5.view.ResultView;

public class RacingGame {
    private final Cars carList;

    public RacingGame(Cars carList) {
        this.carList = carList;
    }

    public void start(int tryCount) {
        while (tryCount-- > 0) {
            carList.move();
            // 여기서 이렇게 출력 뷰를 호출해도 될지,,
            ResultView.print(carList.getCarList());
        }
    }
}
