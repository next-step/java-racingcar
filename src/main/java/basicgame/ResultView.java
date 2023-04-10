package basicgame;

import java.util.List;

public class ResultView {
    public static <T> void printResultList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }
}
