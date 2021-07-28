package racingcar.domain;

public class Score {
    private int number;

    Score() {
        this.number = 0;
    }

    Score(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    void add() {
        this.number++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return number == score.number;
    }
}
