package racing.model;

public interface Racer {
    <T extends Racer> T go();

    String position();
}
