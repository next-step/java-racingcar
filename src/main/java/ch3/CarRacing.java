package ch3;

import java.util.*;

public class CarRacing {

    private final InputView inputView;
    private final ResultView resultView;
    private List<Car> cars;
    private Queue<Integer> executeNumbers = new LinkedList<>();

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public ResultView getResultView() {
        return resultView;
    }

    public void makingCar(int number) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        makingExecuteNumbers();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Queue<Integer> getExecuteNumbers() {
        return this.executeNumbers;
    }

    public void executeRace() {
        for (Car car : cars) {
            car.move(executeNumbers.poll());
        }
        makingExecuteNumbers();
    }

    private void makingExecuteNumbers() {
        Random random = new Random();
        int carSize = cars.size();
        while (carSize-- > 0) {
            this.executeNumbers.add(random.nextInt(10));
        }
    }

    public void startGame() {
        int carCount = inputView.getInputValue("자동차 대수는 몇 대 인가요?");
        makingCar(carCount);
        int executeCount = inputView.getInputValue("시도할 회수는 몇 회 인가요?");
        resultView.showResultComment("실행 결과");
        while (executeCount-- > 0) {
            executeRace();
            resultView.showResultCarRacing(cars);
        }
    }
}
