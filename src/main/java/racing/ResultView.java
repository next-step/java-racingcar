package racing;

import java.util.List;

public class ResultView {
    public static void showStatus(List<Car> cars){
        for (Car car: cars) {
            System.out.println(car.getCarName() + "\t: " + "-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public static void showResult(List<String> cars){
        String resultMessage = "우승자는 ";
        for(int i = 0; i < cars.size(); ++i){
            resultMessage += cars.get(i);
            if(i < cars.size() - 1){
                resultMessage += ", ";
            }
        }
        resultMessage += " 입니다.";
        System.out.println(resultMessage);
    }
}
