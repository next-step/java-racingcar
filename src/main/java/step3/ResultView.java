package step3;

import java.util.Map;

public class ResultView {
    public void getResult(int attemps, Cars cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemps; i++) {
            cars.move();
            resultByRound(cars.getCars());
        }
    }

    public void resultByRound(Map<Integer, String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        System.out.println();
    }
}
