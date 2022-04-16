package racingcar.view;

public class ResultBuilder {

    private static final String DIVISION = " : ";
    private final int position;
    private final String carName;

    public ResultBuilder(int position, String carName) {
        this.position = position;
        this.carName = carName;
    }

    public String build() {
        StringBuilder bs = new StringBuilder();
        bs.append(carName);
        bs.append(DIVISION);
        int i = 0;
        while (i != this.position) {
            bs.append("-");
            i++;
        }
        return bs.toString();
    }
}
