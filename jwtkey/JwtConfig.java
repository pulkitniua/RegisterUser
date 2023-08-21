package com.example.RegisterUser.jwtkey;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.security.SecureRandom;

@Component
public class JwtConfig {

	@Bean
    public Key secretKey() {
          // Generate a strong secret key for HS512 manually
     byte[] keyBytes = new byte[64]; // 64 bytes for HS512
        new SecureRandom().nextBytes(keyBytes);
       return Keys.hmacShaKeyFor(keyBytes);
		//String keys = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY5MjM1NDgyMywiaWF0IjoxNjkyMzU0ODIzfQ.3cGE87RtLLtdg-DhCaBIOlzrCMiyw3mLgSlpcD_JYJA";
		
		}
}
