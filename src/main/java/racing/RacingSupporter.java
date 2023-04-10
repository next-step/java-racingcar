package racing;

public class RacingSupporter {
    public static void judgeRace(Car car, int number) {
        if(number > 3) {
            car.move();
        }
    }
}
