package view;

public class ResultView {

    private StringBuilder stringBuilder = new StringBuilder();


    private void resultRacing() {
        System.out.println(stringBuilder.toString());
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void getResultRacing() {
        resultRacing();
    }
}
