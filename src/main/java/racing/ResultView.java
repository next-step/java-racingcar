package racing;

public class ResultView {
    public static void show_status(int[] cars){
        for (int car: cars) {
            System.out.println("-".repeat(car));
        }
        System.out.println();
    }

    public static void show_result(int[] cars, int moveCount){
        String result_message = "결승점에 도달한 차는 ";
        boolean multi_flag = false;
        for(int index = 0; index < cars.length; ++index){
            if(cars[index] == moveCount){
                if (multi_flag) result_message += ", ";
                result_message += (index + 1);
                multi_flag = true;
            }
        }
        result_message += "번 입니다.";
        System.out.println(result_message);
    }
}
