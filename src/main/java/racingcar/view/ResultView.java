package racingcar.view;

public class ResultView {
    private StringBuilder stringBuilder = new StringBuilder();

    public void roundResult(String carName, int maxPosition) {
        System.out.println(carName + " : " + appendPosition(maxPosition));
    }

    public void emptyLIne() {
        System.out.println("");
    }

    protected String appendPosition(int position) {
        stringBuilder.setLength(0);

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void gameResult(String winner) {
        System.out.println(winner + " 가 우승하였습니다.");
    }
}
