package racingcar.view;

import racingcar.domain.Racing;
import racingcar.domain.RacingCar;

import java.util.List;

public class RacingPrinter {

    public static void printRunStatus(Racing racing){
        for(RacingCar racingCar : racing.getParticipants()){
            RacingCarPrinter.printNameAndRunCount(racingCar);
        }
        System.out.println();
    }

    public static void printFinalWinner(List<RacingCar> winners){
        StringBuilder sb = new StringBuilder();
        String line = "최종 우승자: ";
        sb.append(line);
        for(RacingCar racingCar : winners){
            sb.append(racingCar.whoAmI());
            sb.append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 2));
    }
}
