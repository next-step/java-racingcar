package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingSupporterTest {

    @Test
    @DisplayName("팀 이름 나누기")
    void getTeamReady() {
        assertThat(RacingSupporter.getTeamReady("포비,딸기,오랜지")).containsExactly("포비", "딸기", "오랜지");
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void setCarsForRacing() {
        assertThat(RacingSupporter.setCarsForRacing(RacingSupporter.getTeamReady("포비,딸기,오랜지"))).anyMatch(el -> el.getCarName().equals("포비"));
    }
}