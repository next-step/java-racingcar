package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private static final String START_MESSAGE = "자동차 댓수는 몇 대 인가요?";

    private List<Car> participateCars;

    private int moveCount;

    public CarRacing(int participateCarCount, int moveCount) {
        this.participateCars = addCar(participateCarCount);
        this.moveCount = moveCount;

    }

    public void ready() {
        printMessage(START_MESSAGE);
        printMessage(String.valueOf(participateCars.size()));
        printMessage("시도할 횟수는 몇회 입니까?");
        printMessage(String.valueOf(moveCount));
        printNewLine();
    }

    private List<Car> addCar(int participateCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < participateCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public int participateCarSize() {
        return this.participateCars.size();
    }

    public int racingMoveCount() {
        return this.moveCount;
    }

    public void start() {
        printMessage("실행결과");
        for (int i = 0; i < moveCount; i++) {
            race();
            printNewLine();
        }
    }

    private static void printNewLine() {
        InputView.input("\n");
        OutputView.print();
    }

    private static void printMessage(String message) {
        InputView.input(message);
        OutputView.print();
    }

    private void race() {
        for (Car car : participateCars) {
            car.assignRandomDistance(new Random().nextInt(10));
            car.move();
            car.printMovedState();
        }
    }

}
