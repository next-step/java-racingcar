package racingcar.view;

public class ResultView {
    public String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
