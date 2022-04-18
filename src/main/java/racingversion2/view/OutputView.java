package racingversion2.view;

import java.util.List;
import racingversion2.car.Car;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String CAR_FOOTPRINT = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다";


    public void printResult(){
        System.out.println(System.lineSeparator() + GAME_RESULT);
    }

    public void printCars(List<Car> cars){
        for(Car car : cars){
            String carMoveHistory = printCarMoveHistory(car.getPosition());
            System.out.printf("%s : %s\n", car.getName(), carMoveHistory);
        }
        System.out.println();
    }

    private String printCarMoveHistory(int position) {
        return CAR_FOOTPRINT.repeat(position);
    }

    public void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for(Car car : winners){
            sb.append(car.getName() + WINNER_SEPARATOR);
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb + WINNER_MESSAGE);
    }
}
