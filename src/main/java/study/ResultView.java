package study;

public class ResultView {

    public ResultView() {
    }

    public static void printResult(int[] result, int tryCount) {

        System.out.println("실행 결과");
        for (int i = 1; i < tryCount+1; i++) {
            printEachTry(result, i);
        }

    }


    private static void printEachTry(int[] result, int i){
        for (int j : result) {
            int tryNum = Math.min(j, i);
            printRacing(tryNum);
        }
        System.out.println();
    }


    private static void printRacing(int n){
        for (int j = 0; j < n; j++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
