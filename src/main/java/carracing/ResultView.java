package carracing;

import java.util.List;

public class ResultView {

    public static void getResultComment() {
        System.out.println("");
        System.out.println("실행 결과");
    }

    public static void numberToChar(List<Car> carList) {

        for(Car car : carList) {
            StringBuilder sb = new StringBuilder();
            sb.append("-".repeat(car.distance));
            System.out.println(sb);
        }
        System.out.println("");
    }
}
