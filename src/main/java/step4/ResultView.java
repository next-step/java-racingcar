/*
 * 각 라운드별 자동차 경주의 실행 결과를 출력하는 UI 클래스
 * */
package step4;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    /**
     * 실행 결과 메시지를 출력하는 메소드
     */
    public static void showResultMessage() {
        System.out.println();
        System.out.println(Constants.MSG_RESULT);
    }

    /**
     * 각 라운드 실행결과를 출력하는 메소드
     * @param cars 자동차 경주에 참여한 자동차 리스트
     */
    public static void printRace(List<Car> cars) {
        cars.forEach(ResultView::printEachCar);

        System.out.println();
    }

    /**
     * 매 라운드마다 자동차들이 이동한 상태를 출력하는 메소드
     * @param car 자동차 객체
     * @return 자동차의 이동 위치
     */
    public static String printEachCar(Car car) {
        StringBuilder result = new StringBuilder();
        System.out.print(car.getName());
        System.out.print(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Constants.MOVE_MARK);
            result.append(Constants.MOVE_MARK);
        }

        System.out.println();

        return result.toString();
    }

    /**
     * 우승한 자동차를 출력
     * @param cars 우승한 자동차 리스트
     */
    public static void printWinner(List<Car> cars) {
        System.out.print(getStringOfWinner(cars));
        System.out.println(Constants.RACE_RESULT_MSG);
    }

    /**
     * 우승한 자동차 리스트를 스트링으로 반환하는 메소드
     * @param cars 경주에서 우승한 자동차 리스트
     * @return 우승한 자동차 이름을 ,로 묶어 스트링으로 반환한 값
     */
    private static String getStringOfWinner(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
