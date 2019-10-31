package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCycle;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private List<RacingCycle> cycles;

    private static final String LOCATION_EXPRESSION_STRING = "-";

    public ResultView(List<RacingCycle> cycles) {
        this.cycles = cycles;
    }

    public void printRace() {
        for (RacingCycle cars : cycles) {
            printCycle(cars);
        }
    }

    public void printWinner() {
        if(cycles == null || cycles.size() == 0) {
            throw new IllegalArgumentException("실행된 cycle이 없습니다.");
        }
        RacingCycle finalRoundCycle = cycles.get(cycles.size() - 1);

        List<String> winners = finalRoundCycle.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println(String.format("%s가 최종 우승하였습니다.", String.join(",", winners)));
    }


    private void printCycle(RacingCycle cycle) {
        for (Car car : cycle.getCycle()) {
            System.out.println(drawLocation(car.getName(), car.getLocation()));
        }

        System.out.println();
    }

    private String drawLocation(String name, int location) {
        StringBuilder locationBuilder = new StringBuilder();
        locationBuilder.append(name).append(" : ");
        for (int i = 0; i < location; i++) {
            locationBuilder.append(LOCATION_EXPRESSION_STRING);
        }
        return locationBuilder.toString();
    }

}
