package racingcar;

public class ResultView {

    public void roundResult(String CarName, int maxPosition) {
        System.out.println(CarName + " : " + appendPosition(maxPosition));
    }

    public void emptyLIne() {
        System.out.println("");
    }

    protected String appendPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void gameResult(String winner) {
        System.out.println(winner + " 가 우승하였습니다.");
    }
}
