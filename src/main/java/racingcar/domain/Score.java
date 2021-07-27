package racingcar.domain;

class Score {
    private int score;

    Score(){
        this.score = 0;
    }

    int getScore(){
        return this.score;
    }

    void add(){
        this.score++;
    }

    boolean isSameScore(int score) {
        return this.score == score;
    }

}
