package racingcar;

public class ResultView {
    public static void print(CarRace carRace){
        for(int i=0; i < carRace.getTryCnt(); i++){
            carRace.getRaceResult().get(i).carList.stream().forEach(c -> {
                System.out.println(c.getDistanceToUI());
            });
            System.out.println();
        }
    }
}
