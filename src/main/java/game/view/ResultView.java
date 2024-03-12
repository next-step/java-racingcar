package game.view;

import java.util.List;

public class ResultView {

    public static void printPlainMessage(final String message) {
        System.out.println(message);
    }

    public static void printDistance(final int distance){
        printPlainMessage("-".repeat(Math.max(0, distance)));
    }

    public static void printDistance(final List<Integer> distances){
        distances.forEach(ResultView::printDistance);
    }
}
