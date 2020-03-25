package fifthrefactoring.view;

import fifthrefactoring.domain.Car;

import java.util.List;

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

    public static String makeSign(int carPosition) {
        String finalSign = "";
        for (int i = 0; i < carPosition; i++) {
            finalSign = finalSign.concat(SIGN);
        }
        return finalSign;
    }

    public static void announceRank(String firstCarName) {
        System.out.println(firstCarName + "가 최종 우승했습니다.");
    }
}
