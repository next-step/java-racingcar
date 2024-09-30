package race;

import race.Utils.InputUtils;
import race.vehicle.Vehicles;

public class playGame {

    public static final int INITIAL_LOCATION = 1;

    public static void main(String[] args) {
        InputUtils.inputCarView();
        InputGame inputGame = new InputGame();
        Vehicles vehicles = new Vehicles(inputGame.inputNumber());

//        InputView.inputMoveView();
//        int moveNum = InputView.inputMovementNumber();
//        resultView.printResultView();
//        for (int i = 0; i < moveNum; i++) {
//            for(int j=0 ; j<carNum ; j++){
//                Car car = cars.get(j);
//                resultView.printLocationResultView(car.getLocation());
//                if(j<moveNum)
//                    car.move();
//            }
//            System.out.println();
//        }

    }
}
