package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Winner;

public class ResultView {

    public void resultStart(){
        System.out.println("실행 결과");
    }

    public void resultView(Car car){
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMoveCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinner(List<Winner> winners) {
        String names = winners.stream().map(Winner::getName).collect(Collectors.joining(","));
        System.out.println(names + " 가 최종 우승했습니다.");
    }
}
