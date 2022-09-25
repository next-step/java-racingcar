package carracing.step3;

public class ResultView {

    public void printResults(String result, int playCount) {
        if (playCount == 0) {
            System.out.println("실행 결과");
        }
        System.out.println(result);
    }
}
