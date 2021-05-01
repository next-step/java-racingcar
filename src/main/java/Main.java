import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cars cars = new Cars();

        String names = UI.answer(UIMessage.ASK_CAR_NAME);
        List<String> nameArrays = Arrays.asList(names.split(","));
        cars.setCarsByNames(nameArrays);

        final int count = Integer.valueOf(UI.answer(UIMessage.ASK_BETTING_COUNT));
        System.out.println();

        Computer computer = new Computer(cars);

        UI ui = new UI(cars);

        for (int i = 0; i < count; i++) {
            computer.play();
            ui.printGameResult();
            System.out.println();
        }

        ui.printWinner(count);
        System.exit(0);
    }
}
