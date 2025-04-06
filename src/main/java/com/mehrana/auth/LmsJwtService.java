package com.mehrana.auth;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class LmsJwtService {

    public String generateJwt() {
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "user")
        );
        long duration = System.currentTimeMillis() + 3600;
        return Jwt.issuer("mehrana.auth")
                .subject("mehrana.auth")
                .groups(roles).
                expiresAt(duration)
                .sign();

    }

}
