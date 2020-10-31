/**
 * 클래스 이름: View
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class View {
    public RacingGame game;

    public View(RacingGame game) {
        this.game = game;
    }

    // NOTE: Car 보다 작은 단위로 convert 하지 않도록 한다.
    protected String convertCar(Car car) {
        int position = car.getPosition();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void print() {
        this.game.printCars(car -> {
            String convertedCar = this.convertCar(car);
            System.out.println(convertedCar);
        });
        System.out.println();
    }
}
