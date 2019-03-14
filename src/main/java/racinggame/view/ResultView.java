package racinggame.view;

import racinggame.domain.Car;

import java.util.List;

public class ResultView {

    public void showResultTitle() {
        System.out.println("\n실행 결과");
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
        System.out.println(getWinnerListString(winnerList) + "이(가) 최종 우승했습니다.");
    }

    public String getWinnerListString(List<Car> winnerList) {

        StringBuilder sb = new StringBuilder();

        int lastItemIndex = winnerList.size() - 1;

        for( int i = 0; i < lastItemIndex; ++i ) {
            sb.append(winnerList.get(i).getName() + ", ");
        }
        sb.append(winnerList.get(lastItemIndex).getName());

        return sb.toString();
    }
}