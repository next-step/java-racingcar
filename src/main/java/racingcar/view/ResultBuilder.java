package racingcar.view;

public class ResultBuilder {

    private final int position;

    public ResultBuilder(int position) {
        this.position = position;
    }

    public String build() {
        StringBuilder bs = new StringBuilder();
        int i = 0;
        while (i != this.position) {
            bs.append("-");
            i++;
        }
        return bs.toString();
    }
}
