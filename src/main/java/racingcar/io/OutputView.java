package racingcar.io;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    private static final String VISUAL_EXPRESSION = "-";

    public static void start(){
        System.out.println("게임을 시작합니다.");
    }

    public static void result(){
        System.out.println("실행 결과");
    }

    public static void playResult(List<Car> cars){
        for (Car car : cars) {
            carPosition(car);
        }
        newLine();
    }

    private static void carPosition(Car car) {
        IntStream.range(0, car.getPosition())
                .forEach(value -> print(VISUAL_EXPRESSION));
        newLine();
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
