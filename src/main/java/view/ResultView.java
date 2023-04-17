package view;

import java.util.List;

public class ResultView {

    public static void outputView(List<String[]> result) {
        for (int i = 0; i < result.size(); i++) {
            printEachRound(result.get(i));
            System.out.println();
        }
    }

    public static void printEachRound(String[] eachRound) {
        for (String s : eachRound) {
            System.out.println(s);
        }
    }
}
