package racingcar_step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void showAllStates(List<Car> cars, int tryNum) {
        System.out.println("\n실행결과");

        for (int i = 0; i < tryNum; i++) {
            showEachState(cars, i);
        }
    }

    private static void showEachState(List<Car> cars, int tryIdx) {
        cars.forEach(car -> {
            StringBuilder sb = makeTrace(car, tryIdx);
            System.out.println(car.getName() + " : " + sb);
        });

        System.out.println("");
    }

    private static StringBuilder makeTrace(Car car, int tryIdx) {
        StringBuilder sb = new StringBuilder();
        List<Integer> positionHistory = car.getPositionHistory();
        for (int i = 0; i < positionHistory.get(tryIdx); i++) {
            sb.append('-');
        }
        return sb;
    }

    public static void showWinner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winnerList = new ArrayList<>();

        //인덴트가 2depth일지라도 메소드 분리하면 더 가독성이 않좋을것 같아서 놔둠.
        for (Car car : cars) {
            int pos = car.getPosition();
            if(pos >= maxPosition){
                maxPosition = pos;
            }
        }

        for (Car car : cars) {
            addWinner(maxPosition, winnerList, car);
        }

        System.out.println(String.join(", ", winnerList) + "가 최종 우승했습니다.");
    }

    private static void addWinner(int maxPosition, List<String> winnerList, Car car) {
        if(car.getPosition() == maxPosition)
            winnerList.add(car.getName());
    }
}
