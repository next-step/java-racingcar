package Step1;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

class Result {
    int ball;
    int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }
}

public class Baseball {

    private final int COUNTED_NUMBER = -1;

    private int ball;
    private int strike;

    private int[] comps = null;
    private int[] users = null;

    public Result play(String computer, String user) {
        String[] com_split = computer.split("");
        String[] user_split = user.split("");

        this.comps = parse_to_integers(com_split);
        this.users = parse_to_integers(user_split);

        this.ball = 0;
        this.strike = 0;

        // check strike
        for (int ball_pos = 0; ball_pos < this.comps.length; ball_pos++) {
            update_strike(ball_pos);
        }

        // check ball
        for (int comp_ball_pos = 0; comp_ball_pos < this.comps.length; comp_ball_pos++) {
            update_ball(comp_ball_pos);
        }

        return new Result(this.ball, this.strike);
    }

    private void update_strike(int ball_pos) {
        if (this.comps[ball_pos] != this.users[ball_pos]) {
            return;
        }

        this.comps[ball_pos] = COUNTED_NUMBER;
        this.users[ball_pos] = COUNTED_NUMBER;

        this.strike++;
    }

    private void update_ball(int comp_ball_pos) {
        for (int user_ball_pos = 0; user_ball_pos < this.users.length; user_ball_pos++) {
            update_ball_internal(comp_ball_pos, user_ball_pos);
        }
    }

    private void update_ball_internal(int comp_ball_pos, int user_ball_pos) {
        if (this.comps[comp_ball_pos] == COUNTED_NUMBER ||
                this.users[user_ball_pos] == COUNTED_NUMBER) {
            return;
        }

        if (this.comps[comp_ball_pos] != this.users[user_ball_pos]) {
            return;
        }

        this.comps[comp_ball_pos] = COUNTED_NUMBER;
        this.users[user_ball_pos] = COUNTED_NUMBER;

        this.ball++;
    }

    private int[] parse_to_integers(String[] split) {
        int[] integers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            integers[i] = Integer.parseInt(split[i]);
        }

        return integers;
    }
}