package step4.view;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.List;

public class OutputView {

    private static final String DISPLAY = "-";

    public static void outputMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void outputMessageAboutMove(Cars cars) {
        cars.getCars().forEach(car -> {
            StringBuilder builder = new StringBuilder();
            builder.append(car.getName());
            builder.append(" : ");
            for (int i=0; i<car.getPosition(); i++) {
                builder.append(DISPLAY);
            }
            System.out.println(builder.toString());
        });
        System.out.println();
    }

    public static void outputMessageAboutWinner(String winnerCars) {
        String result = new StringBuilder()
                .append(winnerCars)
                .append("가 최종 우승했습니다").toString();
        System.out.println(result);
    }
}
