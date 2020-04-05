package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static final String DASH = "-";
    private Map<Integer, List<Integer>> record;
    private Cars cars;

    public ResultView(Map<Integer, List<Integer>> record, Cars cars) {
        this.record = record;
        this.cars = cars;
    }

    public void show() {
        System.out.println("실행결과");

        for (int count = 1; count <= record.size(); count++) {
            showCarPositions(record.get(count));
            System.out.println();
        }
        showWinner();
    }

    private String showGraph(int position) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    private void showCarPositions(List<Integer> positions) {
        positions.stream()
                .map(this::showGraph)
                .forEach(System.out::println);
    }

    private void showWinner() {
        List<Car> winners = Winners.findWinners(cars.getCars());
        StringBuilder sb = new StringBuilder();
        for (Car car : winners) {
            sb.append(car.getName() + ",");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 1) + " 가 최종 우승했습니다.");
    }


}
