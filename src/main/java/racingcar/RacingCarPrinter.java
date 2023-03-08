package racingcar;

public class RacingCarPrinter {
    public static void printNameAndRunCount(RacingCar racingCar){
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.whoAmI());
        sb.append(" : ");
        int startCount = 0;
        while( startCount < racingCar.getRunCount()){
            sb.append('-');
            startCount++;
        }
        System.out.println(sb.toString());
    }
}
