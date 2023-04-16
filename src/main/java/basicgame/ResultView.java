package basicgame;

import java.util.List;

public class ResultView {
    public static void printResultList(List<Vehicle> list, String mark) {
        for (Vehicle t : list) {
            System.out.println(t.printDistance(mark));
        }
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }
}
