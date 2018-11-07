package racing.view;

import org.apache.commons.lang3.StringUtils;
import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 결과 UI
 */
public class ResultView {
    // 하이픈
    private static final String HYPEN = "-";

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 모든 차의 위치 출력
     *
     * @param cars 차
     */
    public static void printAll(List<Car> cars) {
        System.out.println();
        cars.forEach(i -> {
            System.out.print(i.getName() + " : ");
            print(i.getPosition());
            System.out.println();
        });
    }

    /**
     * 우승자 출력
     *
     * @param cars
     */
    public static void printWinners(List<Car> cars) {
        List<String> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        String nameJoin = StringUtils.join(names, ", ");
        System.out.println(nameJoin + "가 최종 우승했습니다.");
    }

    /**
     * @param position 위치
     */
    private static void print(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print(HYPEN);
        }
    }


}
