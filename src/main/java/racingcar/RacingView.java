package racingcar;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingView {

    public Consumer<List<Car>> carsConsumer = (cars) -> {
        for (Car car : cars) {
            String carStr = this.convertCar(car);
            System.out.println(carStr);
        }
        System.out.println();
    };

    public Consumer<List<Car>> winnersConsumer = (winners) -> {
        String winnerStr = this.convertWinnerList(winners);
        System.out.println(winnerStr);
    };

    private RacingView() {}

    /**
     * NOTE: 굳이 싱글톤 패턴으로 할 필요는 없지만,
     * InputView 와 인터페이스를 비슷하게 하기 위해 적용했다.
     */
    public static RacingView getInstance() {
        return RacingView.SingletonHelper.instance;
    }

    public void printResultMsg() {
        System.out.println(RacingViewConst.EXECUTION_RESULT_MSG);
    }

    // NOTE: Car 보다 작은 단위로 convert 하지 않도록 한다.
    protected String convertCar(Car car) {
        int position = car.getPosition();
        String name = car.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(RacingViewConst.SEPARATOR);
        for (int j = 0; j < position; j++) {
            sb.append(RacingViewConst.PLAYER_TOKEN);
        }
        return sb.toString();
    }

    protected String convertWinnerList(List<Car> winnerList) {
        List<String> winners = winnerList
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(RacingViewConst.WINNER_DELIMITER, winners) + RacingViewConst.WINNER_MSG;
    }

    private static class SingletonHelper {
        private static final RacingView instance = new RacingView();
    }
}
