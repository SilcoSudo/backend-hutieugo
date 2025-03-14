// package com.hutieugo.backend.security;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     private final long EXPIRATION_TIME = 864_000_00; // 1 ngày

//     // Tạo token
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(key)
//                 .compact();
//     }

//     // Lấy username từ token
//     public String extractUsername(String token) {
//         return Jwts.parserBuilder().setSigningKey(key).build()
//                 .parseClaimsJws(token).getBody().getSubject();
//     }

//     // Kiểm tra token hợp lệ
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }
// }
