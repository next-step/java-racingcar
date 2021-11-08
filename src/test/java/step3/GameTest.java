package step3;

class GameTest {

//
//    @DisplayName("Game 생성 시에 GameInformation에 Names나 time 은 null이면 안된다.")
//    @Test
//    void ofTest() {
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            Game.of(GameInformation.create(null, 10), () -> true);
//        });
//
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            Game.of(GameInformation.create("kay,may", null), () -> true);
//        });
//    }
//
//    @DisplayName("매번 움직이는 정상 케이스 동작 테스트")
//    @Test
//    void moveAlwaysTest() {
//        String namesStr = "kay,may";
//        Integer time = 3;
//        Game game = Game.of(GameInformation.create(namesStr, time), () -> true);
//
//        game.start();
//
//        Position one = Position.create(1);
//        Position two = Position.create(2);
//        Position three = Position.create(3);
//        List<Position> oneStep = Arrays.asList(one, one, one);
//        List<Position> twoStep = Arrays.asList(two, two, two);
//        List<Position> threeStep = Arrays.asList(three, three, three);
//
//        GameHistory gameHistory = game.getGameHistory();
//        assertThat(gameHistory.getHistory(0)).isEqualTo(oneStep);
//        assertThat(gameHistory.getHistory(1)).isEqualTo(twoStep);
//        assertThat(gameHistory.getHistory(2)).isEqualTo(threeStep);
//
//
//    }


}