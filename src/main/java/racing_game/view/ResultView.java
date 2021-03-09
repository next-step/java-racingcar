package racing_game.view;

import java.util.List;
import racing_game.domain.Car;

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

    public void showWinner(List<String> list) {
        System.out.println(list.toString()+ " 가 최종 우승했습니다.");
    }
}
