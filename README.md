# BookInfoREST
Spring Boot를 이용한 RESTful API 만들기


![image](https://user-images.githubusercontent.com/91974804/194017964-71b75b2c-ea8a-4bc4-9716-f970e0b0f157.png)


JAVA 11
- spring boot 2.7.4, 
 - gradle
 - lombok
 - devtools
 - web
 - jdbc


- postgresql lastest(docker), 
- mybatis 2.2.2, 
- swagger2 2.9.2
- swagger-ui 2.9.2
- org.json
- commons-io


ref. [[SPRING BOOT] REST API 간단 예제 - (1) 프로젝트 생성](https://nm-it-diary.tistory.com/96) 
클론 코딩했는데, 환경이 달랐음

난 STS, Postgres 썼는데 Ref는 VSC, Oracle 쓰셨음

차이점으로 바꾼건 

1. mybatis에서 SQL부분에 테이블 다룰 때 큰 따옴표로 감싸줘야했던거랑, 

DB의 book_key col의 자료형이 int였는데, 저번에도 flask 다뤄봐서 느꼈지만 string으로 데이터를 송수신을 했어야하는데 

그대로 string을 db에 넣게 된다면 cast 오류가 나기 때문에 따로 CAST(#{input} AS INTEGER)라고 바꿔줘야했음

버전 달라서 다르게 작성해야 하는 부분도 있었음


2. BookInfoSQL.xml Mapper파일 작성 시 error downloading으로 인해
```
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```
이 부분의 http를 https로 바꿔야했고


3. Swagger 다루는 Controller 파일에
```
@Api(tags = {"01. Book Info"}, description = "도서 관련 서비스")
```
이 부분의 description은 legacy해서 더 이상 쓰이지 않는 문법이 되었음
그래서 Swagger Config 파일에서 Api 메소드에 Docket 옵션 
```
tags(new Tag(BOOK_TAG, "The Book API with Description api tag"))
```
를 달아서
```
@Api(tags = {SwaggerConfiguration.BOOK_TAG})
```
로 대체하게 되었음


4. swagger 다룰때 에러나는것도 버전 연동 오류때문에 났다는데 application properties에서
```
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```
코드 추가했음


나머지는 따라하니 잘됨


![image](https://user-images.githubusercontent.com/91974804/194017613-6d77a8e3-1f73-4667-8202-f2b860b513c7.png)

구조


mybatis-3-mapper.dtd 없어도됨
마이바티스 하도 오류나서 이것저것해보다가 안뺌


그리고 github 너무 불편함
readme 쓰는것도 불편함

