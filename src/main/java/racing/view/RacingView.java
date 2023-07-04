package racing.view;

import racing.Car;
import racing.SimulationResult;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {
    private final static String ASKING_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ASKING_COUNT = "시도할 회수는 몇회인가요?";
    private final static String RESULT_TITLE = "실행 결과";

    public String getAskingCarNameView() {
        return ASKING_CAR_NAME;
    }

    public String getAskingCountView() {
        return ASKING_COUNT;
    }

    public String getResultTitleView() {
        return RESULT_TITLE;
    }

    public String getCarStatusView(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));
    }

    public String getWinnerView(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }

    public String getResultView(SimulationResult simulationResult) {
        return null;
    }
}
