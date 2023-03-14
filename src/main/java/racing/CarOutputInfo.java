package racing;

public class CarOutputInfo {
    private static final String FINAL_WINNER_TEXT = "최종 우승자 : ";

    void display(final Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.print(cars.getCars().get(i).getName() + ':');

            for (int j = 0; j < cars.getCars().get(i).getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    void winnersDisplay(Winners winners) {
        System.out.print(FINAL_WINNER_TEXT);
        winners.getWinners().stream()
                .forEach(name -> System.out.print(name.getName() + ", "));
    }
}
