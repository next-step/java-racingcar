package step3.view;

import step3.model.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static final String BANNER_STRING = "실행 결과";
    public static final String DASH_STRING = "-";

    public static String getDashDistance(int value) {
        // 현재 이 String을 Thread Safe로 할 의미가 없으므로, StringBuilder로 수정
        StringBuilder dashString = new StringBuilder();
        // Java 11에서는 DASH_STRING.REPEAT(value)로 치환 가능
        return dashString.append(String.join("", Collections.nCopies(value, DASH_STRING))).toString();
    }

    private static void showDistanceOfCar(List<Car> challengerList) {
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행

        challengerList.stream()
                .map(car -> getDashDistance(car.showDistance()))
                .forEach(System.out::println);
    }

    public static void runOutputView(List<Car> challengerList) {
        showDistanceOfCar(challengerList);
        System.out.println();
    }

    public static void showOutputViewBanner() {
        System.out.println(BANNER_STRING);
    }
}
