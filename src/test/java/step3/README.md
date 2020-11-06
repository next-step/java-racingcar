
##### 구현기능 목록
- RacingCar 도메인 기능 
- 사용자 질의 응답 기능
- 랜덤명령 생성 테스트
- 참가 차량 댓수에 맞는 RacingCar 인스턴스 생성
- 각 참가차량에 랜덤명령을 전달 테스트

##### Step3 
 - RaceGameContract 인터페이스 : 이너 Presenter, View 인터페이스를 선언함으로써 특정 도메인에서만 사용되도록 제한한다. 
 - Presenter : view와 도메인 모델의 중개역할을 담당한다. 데이터의 흐름을 제어하는 역할 (비즈니스 로직은 절대 제외할것)
 - Commander : 게임규칙을 표현하는 인터페이스 
 - RacingCar : 참가차량의 상태를 표현하는 클래스
 - RacingCars : 모든 참가차량을 표현하는 클래스 
 - RaceRound : Round 상태를 표현하는 클래스 
 - RaceGame : Race 게임 start와 end를 표현하는 클래스 
 
 
 
