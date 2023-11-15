package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String COLON = " : ";
    private static final String PROGRESS = "-";
    private static final String BLANK = "";
    private static final String INFORMATION_FOR_RESULT = "실행결과";
    private static final String INFORMATION_FOR_WINNER = "가 최종 우숭했습니다.";

    public void carStatus(Cars cars) {
        cars.getCars().stream()
                .forEach(car -> System.out.println(car.getCarName().getName() + COLON + PROGRESS.repeat(car.getCarPosition().getPosition())));
        System.out.println(BLANK);
    }

    public void resultMessage() {
        System.out.println(BLANK);
        System.out.println(INFORMATION_FOR_RESULT);
    }
    
    public void showWinner(Winners winners) {
        System.out.println(String.join(", ", winners.getWinners()) + INFORMATION_FOR_WINNER);
    }
}
