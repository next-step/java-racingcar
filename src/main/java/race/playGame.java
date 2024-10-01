package race;

import race.Utils.InputUtils;
import race.vehicle.Vehicles;

public class playGame {
    public static void main(String[] args) {
        Vehicles vehicles = new Vehicles(InputUtils.inputCarView());
        vehicles.gameStart(InputUtils.inputMoveView());
    }
}