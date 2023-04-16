package step3;

public class ResultView {

    public static void printRaceStep(String[][] races){
        for (int k=0; k< races[0].length; k++) {
            raceResult(races, k);
            System.out.println();
        }
    }

    private static void raceResult(String[][] races, int k) {
        for (int i = 0; i< races.length; i++) {
            carRace(k, races[i]);
            System.out.println();
        }
    }

    private static void carRace(int k, String[] races) {
        for (int j = 0; j<= k; j++) {
            System.out.print(races[j]);
        }
    }
}
