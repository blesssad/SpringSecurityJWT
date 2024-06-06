package com.openschool.homework4.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.http.HttpHeaders;

@UtilityClass
public class TokenParser {
    public String getToken(HttpServletRequest request) {
        String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}
