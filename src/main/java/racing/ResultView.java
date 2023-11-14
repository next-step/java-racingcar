package racing;

import java.util.List;

public class ResultView {
    public static void showStatus(List<Car> carList){
        for (Car car: carList) {
            System.out.println("-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public static void showResult(List<Car> carList){
        String resultMessage = "가장 멀리 도달한 차는 ";
        boolean multiFlag = false;
        int maxMoveCount = getMaxMoveCount(carList);
        for(int index = 0; index < carList.size(); ++index){
            if(carList.get(index).getMoveCount() == maxMoveCount){
                if (multiFlag) resultMessage += ", ";
                resultMessage += (index + 1);
                multiFlag = true;
            }
        }
        resultMessage += "번 입니다.";
        System.out.println(resultMessage);
    }

    private static int getMaxMoveCount(List<Car> carList) {
        int maxMove = 0;
        for(Car car : carList){
            maxMove = Math.max(maxMove, car.getMoveCount());
        }
        return maxMove;
    }
}
