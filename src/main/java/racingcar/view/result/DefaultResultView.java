package racingcar.view.result;

import racingcar.domain.RacingCars;

public class DefaultResultView implements ResultView {

    @Override
    public void printHeader() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printBody(RacingCars racingCars) {
        /*
        racingCars.getCarPosition().stream()
                .forEach(DefaultResultView::printCar);
        */
        System.out.println();
    }

    /*
    private static void printCar(CarPosition carPosition) {
        System.out.print(carPosition.getName() + " : ");
        for (int i=0; i<carPosition.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    */

    @Override
    public void printFooter(RacingCars racingCars) {
        //System.out.println(String.join(",", racingCars.getWinners()) + "가 최종 우승했습니다.");
    }
}