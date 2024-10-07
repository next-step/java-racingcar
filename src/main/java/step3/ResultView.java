package step3;

public class ResultView {

    public static void result(int[][] ints) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.println(appendBar(j, ints[i]));
            }
            System.out.println();
        }
    }

    private static StringBuilder appendBar(int j, int[] ints) {
        StringBuilder distance = new StringBuilder();
        for (int k = 0; k < ints[j]; k++) {
            distance.append("-");
        }
        return distance;
    }
}
