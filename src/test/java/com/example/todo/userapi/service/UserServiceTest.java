package com.example.todo.userapi.service;

import com.example.todo.userapi.dto.reqeust.UserRequestSignUpDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UserServiceTest {

    @Autowired
    UserService userService;



    @Test
    @DisplayName("중복된 이메일로 회원가입을 시도하면"+ "RunTimeExemption이 발생해야한다")
     void validateEmailTest() {
        //given
        String email = "db1234@abc.com";
        //when
        UserRequestSignUpDTO dto = UserRequestSignUpDTO.builder().email(email).password("dfsdfs").userName("dfsdsf").build();
        //then
        //param 1 : 어떤에러가 발생할지 에러클래스를 적음
        //param 2 : 에러가 발생하는 상황을 전달
        assertThrows(RuntimeException.class,
                ()-> {userService.create(dto);}
        );
    }
}