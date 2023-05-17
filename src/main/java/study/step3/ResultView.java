package study.step3;

public class ResultView {
    public void print(String[][] result){
        System.out.println("\n실행 결과");

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
            System.out.println();
        }
    }
}
