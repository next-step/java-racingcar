package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;
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
        System.out.print(car.getName() + " : ");
        printPosition(car.getPosition());
        newLine();
    }

    private static void printPosition(Position position) {
        for (int i=0; i < position.parseInt(); i++){
            System.out.print(VISUAL_EXPRESSION);
        }
    }

    public static void winningResult(WinningResult result) {
        System.out.print(result.getNames().get(0));
        for (String name: result.getNames()) {
            System.out.print(", " + name);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public static void end(){
        System.out.println("게임을 종료합니다.");
    }

    private static void newLine() {
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
