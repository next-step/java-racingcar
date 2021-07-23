package racing;

interface Racer {
    <T extends Racer> T go();

    String position();
}
