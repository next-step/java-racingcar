package racing;

import java.util.List;

public class ResultView {
    public static void showStatus(List<Car> carList){
        for (Car car: carList) {
            System.out.println("-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public static void showResult(List<Car> carList, int moveCount){
        String resultMessage = "결승점에 도달한 차는 ";
        boolean multiFlag = false;
        for(int index = 0; index < carList.size(); ++index){
            if(carList.get(index).getMoveCount() == moveCount){
                if (multiFlag) resultMessage += ", ";
                resultMessage += (index + 1);
                multiFlag = true;
            }
        }
        resultMessage += "번 입니다.";
        System.out.println(resultMessage);
    }
}
