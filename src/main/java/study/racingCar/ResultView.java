package study.racingCar;

public class ResultView {

    static void printRacing(Position position){
        for (int i = 0; i < position.position(); i++) {
            System.out.print("-");
        }
    }

}
