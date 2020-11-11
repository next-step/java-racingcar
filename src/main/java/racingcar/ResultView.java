package racingcar;

public class ResultView {
    public static void print(CarRace carRace){
        for(int i=0; i < carRace.getTryCnt(); i++){
            carRace.getRaceResult().get(i).carList.stream().forEach(c -> {
                System.out.println(getDistanceToUI(c));
            });
            System.out.println();
        }
    }

    public static String getDistanceToUI(CarSnapshot carSnapshot){
        String result = "";
        for(int i=0; i < carSnapshot.getDistance(); i++){
            result += "-";
        }
        return result;
    }
}
