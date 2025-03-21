package racing;

class LuckyDice implements Dice {
    public int roll() {
        return Car.MOVE_THRESHOLD + 1;
    }
}
