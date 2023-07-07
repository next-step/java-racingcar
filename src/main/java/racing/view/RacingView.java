package racing.view;

import racing.domain.CarCollection;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {
    private final static String ASKING_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ASKING_COUNT = "시도할 회수는 몇회인가요?";
    private final static String RESULT_TITLE = "\n실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    public void printCarNameAsking() {
        System.out.println(ASKING_CAR_NAME);
    }

    public void printCountAsking() {
        System.out.println(ASKING_COUNT);
    }

    public void printCarStatus(CarCollection cars) {
        String carStatus = cars.getCars().stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));

        System.out.println(carStatus + "\n");
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_TEXT);
    }

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }
}
