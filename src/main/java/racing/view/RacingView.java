package racing.view;

import racing.model.RacingModel;

public class RacingView {

    void printMoveLine(int carMove) {
        for (int i=0; i<carMove; i++) {
            System.out.print("-");
        }
    }

    public void printCarMove(RacingModel racingModel) {
        for (int carNumber=0; carNumber<racingModel.getRacingModelMap().size(); carNumber++) {
            printMoveLine(racingModel.getRacingModelMap().get(carNumber));
            System.out.println("");
        }
        System.out.println("");
    }

}
