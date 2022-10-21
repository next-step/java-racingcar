package step3.view;

import java.util.List;
import step3.domain.Car;
import step3.domain.Name;
import step3.domain.Position;

public class ResultView {

    public void startView() {
        System.out.println("실행 결과");
    }

    public void resultView(Name carName, Position position) {
        System.out.print(carName + " : ");
        for(int i = 0; i < position.currentPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void winnerView(List<Car> cars) {
        String[] names = new String[cars.size()];
        for(int i = 0; i < cars.size(); i ++) {
            names[i] = cars.get(i).currentName().toString();
        }
        System.out.print(String.join(", ", names) + " 가 최종 우승했습니다.");
    }
}
