package racinggame;

import java.util.List;

public class ResultView {

    public static void showCarPositions(List<Car> carList) {
        System.out.println("실행 결과");

        for( Car curCar : carList ) {
            showCarPosition(curCar);
        }
        System.out.println();
    }

    private static void showCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for( int i = 0; i < car.getPosition(); ++i ) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinners(List<Car> winnerList) {
        String winnerListStr = getWinnerListString(winnerList);
        System.out.println(winnerListStr + "이(가) 최종 우승했습니다.");
    }

    private String getWinnerListString(List<Car> winnerList) {
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < winnerList.size(); ++i ) {
            Car curCar = winnerList.get(i);
            sb.append(curCar.getName());

            if( i < winnerList.size()-1 ) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}