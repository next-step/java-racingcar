package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.RacingEvent;
import racing.domain.Car;
import racing.domain.Winner;

public class ResultView {

    public static final String MOVE_DASH = "-";

    public ResultView() {
    }

    public ResultView(RacingEvent racingEvent) {
        List<Winner> winners = racingEvent
            .getWinners()
            .winners(racingEvent.getCars());
        showWinner(winners);
    }

    public void printCarMove() {
        System.out.print(MOVE_DASH);
    }

    public void printResultStart(){
        System.out.println("실행 결과");
    }

    public void resultView(Car car){
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMoveCount(); i++){
            printCarMove();
        }
        System.out.println();
    }

    public void showWinner(List<Winner> winners) {
        String names = winners.stream().map(Winner::getName).collect(Collectors.joining(","));
        System.out.println(names + " 가 최종 우승했습니다.");
    }
}
