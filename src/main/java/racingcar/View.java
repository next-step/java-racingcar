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

    protected String convertCar(Car car) {
        int position = car.getPosition();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        Car[] carArr = this.memento.getCarArr();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carArr.length; i++) {
            String carStr = this.convertCar(carArr[i]);
            sb.append(carStr);
            sb.append("\n");
        }
        return sb.toString();
    }
}
