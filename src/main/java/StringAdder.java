class StringAdder {
    private final Numbers numbers;

    StringAdder(String numbers) {
        this.numbers = Numbers.of(numbers);
    }

    public int calc() {
        if (numbers.containsNegative()) {
            throw new RuntimeException("Negative values does not support addition.");
        }

        return numbers.sum();
    }
}
