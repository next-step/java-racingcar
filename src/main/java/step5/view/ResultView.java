package step5.view;

import step5.domain.RacingCars;

import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showResult(RacingCars racingCars) {
        racingCars.getCars().forEach(it -> {
            System.out.print(it.getName() + " : ");
            printPosition(it.getPosition());
        });
        System.out.println();
    }


    private void printPosition(int position) {
        for (int i = 0; i <= position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinner(List<String> winners) {
        String winnerName = String.join(",", winners);
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
