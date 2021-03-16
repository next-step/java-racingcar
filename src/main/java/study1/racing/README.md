# 기능목록

---

- ## racing

  - ### Race.java
    - field
      - participant / 자동차대수
      - round / 몇회
        ㅡ method
      - run / 레이스 시작 / round 만큼 for
      - checkDistance / 자동차의 거리 측정 / participant 만큼 for
      - recordDistance / 기록 / console 에 출력
  - ### Car.java
    - field
      - distance / 주행거리
    - method
      - move / 이동 / 1 or 0 만큼 주행거리 +
      - getDistance / 현재 거리 반환
      - setDistance / 현재 거리 + 새로운 거리
      - moveDistance / random 으로 0 ~ (maxDistance + 1)
