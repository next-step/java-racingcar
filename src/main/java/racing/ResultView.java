package racing;

public class ResultView {
    public static void showStatus(Car[] cars){
        for (Car car: cars) {
            System.out.println("-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public static void showResult(Car[] cars, int moveCount){
        String resultMessage = "결승점에 도달한 차는 ";
        boolean multiFlag = false;
        for(int index = 0; index < cars.length; ++index){
            if(cars[index].getMoveCount() == moveCount){
                if (multiFlag) resultMessage += ", ";
                resultMessage += (index + 1);
                multiFlag = true;
            }
        }
        resultMessage += "번 입니다.";
        System.out.println(resultMessage);
    }
}
