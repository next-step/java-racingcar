package racinggame.view;

import racinggame.domain.Car;

import java.util.List;

public class ResultView {
    static final String RESULT_TITLE = "\n실행 결과";
    static final String POSITION_STRING = "-";
    static final String WINNING_MESSAGE = "이(가) 최종 우승했습니다.";
    static final String WINNER_SEPARATOR = ",";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showCarPositions(List<Car> carList) {
        for( Car curCar : carList ) {
            showCarPosition(curCar);
        }
        System.out.println();
    }

    void showCarPosition(Car car) {
        System.out.print(car.getName() + " : " );
        for( int i = 0; i < car.getPosition(); ++i ) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinners(List<Car> winnerList) {
        System.out.println(getWinnerListString(winnerList) + WINNING_MESSAGE);
    }

    public String getWinnerListString(List<Car> winnerList) {

        StringBuilder sb = new StringBuilder();

        int lastItemIndex = winnerList.size() - 1;

        for( int i = 0; i < lastItemIndex; ++i ) {
            sb.append(winnerList.get(i).getName() + WINNER_SEPARATOR);
        }
        sb.append(winnerList.get(lastItemIndex).getName());

        return sb.toString();
    }
}