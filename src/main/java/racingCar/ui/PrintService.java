package racingCar.ui;

public class PrintService {

    static public void printDistance(int number){
        String distance = getDistance(number);
        System.out.println(distance);
    }

    static public void printDistanceWithName(int number, String name){
        String distance = getDistance(number);
        System.out.println(name +" : "+distance);
    }

    private static String getDistance(int number) {
        StringBuilder distance = new StringBuilder();
        for(int i = 0; i< number; i++){
            distance.append("-");
        }
        return distance.toString();
    }

    public static void printEmptyLine(){
        System.out.println();
    }

}
