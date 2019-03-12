package racinggame.View;

import racinggame.domain.Car;
import java.util.List;

import static utils.ConstantCollection.DELIMITER;

public class PrintRacing {

    // 결과를 출력하는 메서드
    public static void printRacing(List<Car> carList) {
        System.out.println("실행 결과");

        for(Car car : carList) {
            System.out.print(car.getName() + " : ");
            System.out.println(car.getViewMoving());
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.print(setPrintFormat(winners));
        System.out.println(" 가 최종 우승했습니다.");
    }

    public static String setPrintFormat(List<String> winners) {
        StringBuilder winnersForPrint = new StringBuilder();

        for(String winner : winners) {
            winnersForPrint.append(winner).append(DELIMITER);
        }

        return winnersForPrint.substring(0, winnersForPrint.length() - 1);
    }
}
