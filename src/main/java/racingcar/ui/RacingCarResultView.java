package racingcar.ui;

import java.util.List;

import racingcar.RacingCar;

public class RacingCarResultView {

    private final static RacingCarResultView INSTANCE = new RacingCarResultView();

    private RacingCarResultView() {}

    public static RacingCarResultView getInstance() {
        return INSTANCE;
    }

    public void viewCurrent(List<RacingCarResult> racingCars) {
        for (RacingCarResult car : racingCars) {
            System.out.println(car);
        }

        System.out.println();
    }


    public void viewWinners(List<RacingCarResult> winners) {
        StringBuilder sb = new StringBuilder();
        int lastIndex = winners.size() - 1;

        for (int i = 0; i < lastIndex; i++) {
            RacingCarResult winner = winners.get(i);
            sb.append(winner.getCarName());
            sb.append(", ");
        }

        sb.append(winners.get(lastIndex).getCarName());
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }
}
