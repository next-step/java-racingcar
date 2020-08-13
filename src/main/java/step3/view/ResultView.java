package step3.view;

public class ResultView {

    private static final String MARK = "-";


    public void resultOutput(int moveStatus) {
        String resultMark = "-";

        for (int i = 0; i < moveStatus; i++) {
            resultMark = resultMark + MARK;
        }
        System.out.println(resultMark);
    }

}
