# 자동차 경주 게임

## step3 요구사항 

1. Car class
이동
현재위치 반환  
2. RacingGame class
InputView를 통해 게임에 필요한 파라미터를 받아서 게임을 초기화한다
-> car 개수 , turn 
게임 실행
3. RandomInt 
0~9 사이의 랜덤 값 생성 
랜덤 값이 4 이상인 경우에만 1칸 이동
4. InputView
5. ResultView
6. 각 자동차에 이름을 부여한다. 이름은 5자를 초과할 수 없다. 
7. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
8. 자동차 이름은 쉼표(,)를 기준으로 구분한다. 
9. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
10. RacingGame 에서 랜덤값 생성 로직을 분리하기 위해, GameRule 인터페이스를 만든다. 
11. 테스트에서는 TestGameRule 클래스를 구현해두고, RacingGame이 TestGameRule을 적용하도록 해보자. 

## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)