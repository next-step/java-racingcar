package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private static final String START_MESSAGE = "자동차 댓수는 몇 대 인가요?";

    private ParticipatedCars participatedCars;

    private int moveCount;

    public CarRacing(int participateCarCount, int moveCount) {
        this.participatedCars = new ParticipatedCars(addCar(participateCarCount));
        this.moveCount = moveCount;

    }

    public void ready() {
        printMessage(START_MESSAGE);
        printMessage(String.valueOf(participatedCars.count()));
        printMessage("시도할 횟수는 몇회 입니까?");
        printMessage(String.valueOf(moveCount));
        OutputView.printNewLine();
    }

    private List<Car> addCar(int participateCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < participateCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public int racingMoveCount() {
        return this.moveCount;
    }

    public void start() {
        printMessage("실행결과");
        for (int i = 0; i < moveCount; i++) {
            participatedCars.race();
        }
    }

    private static void printMessage(String message) {
        InputView.input(message);
        OutputView.print();
    }


}
