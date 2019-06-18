package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.WinningResult;

import java.util.stream.IntStream;

public class OutputView {

    private static final String VISUAL_EXPRESSION = "-";

    public static void start(){
        System.out.println("게임을 시작합니다.");
    }

    public static void ready(Cars result){
        System.out.println("실행 결과");
        playResult(result);
    }

    public static void playResult(Cars cars){
        for (Car car : cars.getCars()) {
            playCarResult(car);
        }
        newLine();
    }

    private static void playCarResult(Car car) {
        print(car.getName() + " : ");
        IntStream.range(0, car.getPosition())
                .forEach(value -> print(VISUAL_EXPRESSION));
        newLine();
    }

    public static void winningResult(WinningResult result) {
        for (String name: result.getNames()) {
            System.out.print(name + ", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public static void end(){
        System.out.println("게임을 종료합니다.");
    }

    private static void newLine() {
        System.out.println();
    }

    private static void print(String text){
        System.out.print(text);
    }
}
