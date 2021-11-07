package race.outbound;

import race.Car;
import race.RenderRaceSnapshot;

import java.util.Collection;

public class RenderRaceSnapshotViaConsole implements RenderRaceSnapshot {
    public void render(Collection<Car> cars) {
        cars.forEach((car) -> renderLocation(car.location()));
        System.out.println("\n");
    }

    private void renderLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
