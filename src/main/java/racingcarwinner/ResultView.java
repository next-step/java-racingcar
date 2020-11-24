package racingcarwinner;

public class ResultView {

    public static void resultView(){
        System.out.println("실행 결과");
    }

    public static void carNameView(Car car){
        System.out.print(car.getName().getString()+ " : ");
    }

    public static void carPositionView(Car car){
        for (int i = 0; i < car.getPosition().getValue(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void breakLine(){
        System.out.println();
    }

    public static void winnersView(Winners winners){
        System.out.print(winners.getWinner(0).getName().getString());

        for (int i = 1; i < winners.getCount(); i++) {
            System.out.print(", " + winners.getWinner(i).getName().getString());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
