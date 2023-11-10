package study.race;

import java.util.List;

public class ViewResult {

    public void printResult(int[] results) {
        for (int result: results) {
            System.out.println("-".repeat(result));
        }
        System.out.println("");
    }
}
