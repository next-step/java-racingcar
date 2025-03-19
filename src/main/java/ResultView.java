public class ResultView {
    private String[] raceResult;

    public ResultView(int carNumber) {
        System.out.println("실행 결과");

        raceResult = new String[carNumber];
        for (int i = 0; i < carNumber; i++) {
            raceResult[i] = "";
        }
    }

    public void write(int carIndex) {
        raceResult[carIndex] += "-";
    }

    public void read() {
        for (String result : raceResult) {
            System.out.println(result);
        }
        System.out.println();
    }
}
