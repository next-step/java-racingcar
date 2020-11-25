package racingcarrefectoring.view;

import racingcarrefectoring.model.Car;
import racingcarrefectoring.model.Cars;
import racingcarrefectoring.model.Winners;

public class ResultView {

    public static void resultMessage(){
        System.out.println("실행 결과");
    }

    public static void relayBroadCaseView(Cars cars){
        for (int i = 0; i < cars.getCount(); i++) {
            System.out.print(cars.getCar(i).getName().getString() + " : ");
            CarPositionView(cars.getCar(i));
        }
        System.out.println();
    }

    private static void CarPositionView(Car car){
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public  static void viewWinners(Winners winners){
        System.out.print(winners.getWinner(0).getName().getString());
        for (int i = 1; i < winners.getWinnersCount(); i++) {
            System.out.print(", " + winners.getWinner(i).getName().getString());
        }
        System.out.println("가 우승자입니다");
    }
}
