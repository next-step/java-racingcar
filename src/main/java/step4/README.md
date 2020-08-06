# 4단계 - 자동차 경주(우승자)

---
## 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    
---
## Feature List
0. step3 에서 리팩토링으로 시작!
1. Reception 클래스에서 CarName을 쉼표로 구분한 입력값을 받은 후 구분 된 배열로 변환할 수 있게 작성
2. ParticipationForm 클래스에서 String 배열을 멤버 변수로 갖고 있게 작성
3. RacingCars 클래스에서 String 배열을 이용해 배열 수 만큼 car 객체를 생성하게 작성
4. Car, CarWentResult 클래스에서 CarName을 멤버 변수로 갖고 있게 작성
5. AttemptResult에서 한 회차에서 가장 앞서고 있는 Car의 CarName(여러명 가능)을 쉼표로 붙인 String을 반환하게 작성 
6. RaceResult에서 마지막 바퀴에서 가장 앞서고 있는 Car의 CarName(여러명 가능)을 쉼표로 붙인 String 반환하게 작성
7. Announcer에서 매 회 경기 현황을 출력해 줄 때 CarName을 붙여주고, 최종 우승자를 출력해주게 작성