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

    public InputView inputView() {
        return inputView;
    }

    public ResultView resultView() {
        return resultView;
    }

    public void makingCar(String inputString) {
        String[] names = inputString.split(",");
        this.cars = new ArrayList<>();
        makingNamingCars(names);
        makingExecuteNumbers();
    }

    private void makingNamingCars(String[] names) {
        for (String name : names) {
            Car car = new Car();
            car.makeName(name);
            cars.add(car);
        }
    }

    public int totalCarCount() {
        return cars.size();
    }

    public List<Car> cars() {
        return this.cars;
    }

    public Queue<Integer> executeNumbers() {
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
        String names = inputView.getInputStringValue("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        makingCar(names);
        int executeCount = inputView.getInputIntValue("시도할 회수는 몇 회 인가요?");
        resultView.showResultComment("실행 결과");
        while (executeCount-- > 0) {
            executeRace();
            resultView.showCarRacing(cars);
        }
        resultView.showResultCarRacing(getWinningRaceCars());
    }

    public List<Car> getWinningRaceCars() {
        int maxPosition = findMaxPosition();
        return findWinningCars(maxPosition);
    }

    private List<Car> findWinningCars(int maxPosition) {
        List<Car> winningCars = new ArrayList<>(cars);
        winningCars.removeIf(it -> !it.isWinningCar(maxPosition));
        return winningCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.position(), maxPosition);
        }
        return maxPosition;
    }
}
