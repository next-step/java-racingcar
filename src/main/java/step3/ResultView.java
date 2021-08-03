package step3;

public class ResultView {

    public void printGameResult(int[][] gameResults) {
        System.out.println("실행 결과");

        for(int i = 0; i < gameResults.length; i++) {
            int[] result = gameResults[i];

            for (int j = 0; j < result.length; j++) {
                printOneResult(result[j]);
            }

            System.out.println();
        }

    }

    private void printOneResult(int result) {

        for(int i = 0; i < result; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

}
