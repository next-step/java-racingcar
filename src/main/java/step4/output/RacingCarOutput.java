package step4.output;

import step4.Car;

import java.util.List;

public class RacingCarOutput {

    private static final String CAR_POSITION_INDEX = "-";

    public static void printCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void printRacingResult(List<Car> cars) {


        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.get(i).getCarName();
            int position = cars.get(i).getLocation();
            System.out.println(carName + " : " + CAR_POSITION_INDEX.repeat(position));
        }
        printDividingLine();
    }

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printDividingLine() {
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
