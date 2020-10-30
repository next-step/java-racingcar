/**
 * 클래스 이름: View
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class View {
    public Memento memento;

    public View(Memento memento) {
        this.memento = memento;
    }

    protected String convertCarPosition(int carPosition) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < carPosition; j++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        int[] carPositions = this.memento.getCarPositions();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPositions.length; i++) {
            sb.append(this.convertCarPosition(carPositions[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}
