package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {}

    /**
     * NOTE: 굳이 싱글톤 패턴으로 할 필요는 없지만,
     * InputView 와 인터페이스를 비슷하게 하기 위해 적용했다.
     */
    public static OutputView getInstance() {
        return OutputView.SingletonHelper.instance;
    }

    public void printResultMsg() {
        System.out.println(OutputViewConst.EXECUTION_RESULT_MSG);
    }

    // NOTE: Car 보다 작은 단위로 convert 하지 않도록 한다.
    protected String convertCar(Car car) {
        int position = car.getPosition();
        String name = car.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(OutputViewConst.SEPARATOR);
        for (int j = 0; j < position; j++) {
            sb.append(OutputViewConst.PLAYER_TOKEN);
        }
        return sb.toString();
    }

    private void printCars(List<Car> cars) {
        for (Car car : cars) {
            String carStr = convertCar(car);
            System.out.println(carStr);
        }
        System.out.println();
    }

    public void printHistory(History history) {
        List<Memento> mementoList = history.getMementoList();
        for (Memento memento : mementoList) {
            List<Car> cars = memento.getCars();
            printCars(cars);
        }
    }

    protected String convertWinnerList(List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getName)
                .collect(
                        Collectors.joining(OutputViewConst.WINNER_DELIMITER)
                ) + OutputViewConst.WINNER_MSG;
    }

    public void printWinners(List<Car> winners) {
        String winnerStr = convertWinnerList(winners);
        System.out.println(winnerStr);
    }

    private static class SingletonHelper {
        private static final OutputView instance = new OutputView();
    }
}
