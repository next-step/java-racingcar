package ch01.step2;

public class ResultView {
    String[] progressArr;

    public ResultView() {

    }

    public ResultView(String[] progressArr) {
        this.progressArr = progressArr;
    }

    public void print() {
        for (int i = 0; i < progressArr.length; i++) {
            System.out.println(progressArr[i]);
        }
    }

}
