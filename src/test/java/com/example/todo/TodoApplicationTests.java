package com.example.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootTest
class TodoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("토큰 서명해시값 생성하기")
	void makeSeretKey() {
	    //given
		SecureRandom random = new SecureRandom();
		byte[] key = new byte[64]; // 64 bytes = 512 bits
		random.nextBytes(key);
		String encodedKey = Base64.getEncoder().encodeToString(key);
		System.out.println("\n\n\n");
		System.out.println(encodedKey);
		System.out.println("\n\n\n");
	    //when

	    //then
	}

}
