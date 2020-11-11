# 자동차 경주 게임
## 기능 구현
* Intput, Output 
* 관련 객체 구현
  * Model
    * Car
    * Cars
    * Motor
        * Car 행동에 맞는 전략패턴 구현
  * DTO 
    * RaceReadyValue
        * 레이스에 필요한 input value를 담고 있다.
    * RaceResultValue
        * 레이스에 필요한 ouput value를 담고 있다.
        * key:car.name, value:List<StepByCar> Map 형태의 멤버 변수를 가지고 있다.
    * StepByCar
        * 각 레이싱 단계마다의 Car 상태값을 가진 DTO
- RacingCarService 구현
  * 경주에 필요한 Car 객체 생성 메소드
  * 레이스 단계에 맞게 Car 이동
- RacingCarApplication 구현
  * main 메소드