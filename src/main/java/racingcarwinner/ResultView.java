package racingcarwinner;

public class ResultView {

    public static void viewResultMessage(){
        System.out.println("실행 결과");
    }

    public static void viewCarsTravelDistance(Car car){
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getTravelDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void viewWinner(){
        System.out.print(Winner.getWinner(0));
        for (int i = 1; i < Winner.winnerCount(); i++) {
            System.out.print(", " + Winner.getWinner(i));
        }
        System.out.println("가 최종 우승하였습니다");
    }
}
