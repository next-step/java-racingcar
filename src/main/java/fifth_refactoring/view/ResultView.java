package fifth_refactoring.view;

import fifth_refactoring.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SIGN = "-";
    private static final String TITLE = "실행 결과";

    public static void getTitle() {
        System.out.println(TITLE);
    }

    public static void draw(List<Car> carList) {
        System.out.println();
        for (Car car : carList) {
            String sign = makeSign(car.getCarPosition());
            System.out.println(car.getCarName() + ":\t" + sign);
        }
    }

    public static String makeSign(int carPosition){
        String finalSign = "";
        for (int i = 0; i < carPosition; i++) {
            finalSign = finalSign.concat(SIGN);
        }
        return finalSign;
    }

    public static void announceRank(List<Car> car) {
        String firstCarName = setRank(car);
        System.out.println(firstCarName + "가 최종 우승했습니다.");
    }

    public static String setRank(List<Car> car) {
        Collections.sort(car);

        int maxPosition = car.get(car.size()-1).getCarPosition();

        return car.stream()
                .filter(d -> d.getCarPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
