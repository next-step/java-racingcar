package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private static final String START_MESSAGE = "자동차 댓수는 몇 대 인가요?";
    private List<Car> participateCars;

    private int moveCount;


    public CarRacing(int participateCarCount, int moveCount) {
        this.participateCars = participateCars(participateCarCount);
        this.moveCount = moveCount;

    }

    public void ready() {
        InputView.input(START_MESSAGE);
        OutputView.print();

        InputView.input(String.valueOf(participateCars.size()));
        OutputView.print();

        InputView.input("시도할 횟수는 몇회 입니까?");
        OutputView.print();

        InputView.input(String.valueOf(moveCount));
        OutputView.print();
    }


    private List<Car> participateCars(int participateCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < participateCars; i++) {
            carList.add(new Car(i));
        }
        return carList;
    }

    public int participateCarSize() {
        return this.participateCars.size();
    }

    public int racingMoveCount() {
        return this.moveCount;
    }
}
