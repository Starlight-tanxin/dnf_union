package com.tx.union.secruity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author tanxin
 * @date 2019/5/14
 */
public class JwtUtils {

    /**
     * Token Header
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token value prefix
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * Token密钥
     */
    private static final String SECRET = "DEFAULT_MY_SECRET";
    // 签发者
    private static final String ISSUER = "tx";
    // 主题
    private static final String SUBJECT = "user";
    // 用户id
    private static final String USER_ID = "user_Id";
    // 用户名
    private static final String USERNAME = "username";


    /**
     * 根据当前时间生成Token过期时间（默认过期时间为1小时）
     *
     * @return 过期时间
     */
    private static Date generateExpirationDate() {
        return Date.from(LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 生成token
     *
     * @param claims
     * @return
     */
    private static String createToken(Map<String, String> claims) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER) // 签发者
                .withSubject(SUBJECT) // 主题
                .withIssuedAt(new Date()) // 签发时间
                .withExpiresAt(generateExpirationDate());
        claims.forEach(builder::withClaim);
        return builder.sign(algorithm);
    }

    /**
     * 检验token 获取数据
     *
     * @param token
     * @return
     */
    private static Map<String, String> verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)// 签发者
                .withSubject(SUBJECT) // 主题
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> map = jwt.getClaims();
        Map<String, String> resultMap = new HashMap<>(map.size());
        for (Map.Entry<String, Claim> entry : map.entrySet()) {
            String key = entry.getKey();
            Claim val = entry.getValue();
            resultMap.put(key, val.asString());
            if (PublicClaims.ISSUED_AT.equals(key) || PublicClaims.EXPIRES_AT.equals(key)) {
                resultMap.put(key, Long.toString(val.asDate().getTime()));
            }
        }
        return resultMap;
    }

    /**
     * 判断token是否过期
     *
     * @param token
     * @return true - 过期  false - 未过期
     */
    public static boolean isTokenExpired(String token) {
        long now = new Date().getTime();
        Map<String, String> dataMap = verifyToken(token);
        String exp = dataMap.get(PublicClaims.EXPIRES_AT);
        return now > Long.valueOf(exp);
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        Map<String, String> dataMap = verifyToken(token);
        return dataMap.get(USERNAME);
    }

    /**
     * 获得用户id
     *
     * @param token
     * @return
     */
    public static Integer getUserId(String token) {
        Map<String, String> dataMap = verifyToken(token);
        return Integer.valueOf(dataMap.get(USER_ID));
    }

    /**
     * 获取Token
     *
     * @param request HttpServletRequest
     * @return Token
     */
    public static String getToken(HttpServletRequest request) {
        String header = request.getHeader(TOKEN_HEADER);
        if (Strings.isNullOrEmpty(header)) {
            header = request.getParameter(TOKEN_HEADER);
        }
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            return header.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    /**
     * 生成token
     *
     * @param id       用户id
     * @param username 用户名
     * @return
     */
    public static String generateToken(Integer id, String username) {
        Map<String, String> claims = new HashMap<>();
        claims.put(USER_ID, Integer.toString(id));
        claims.put(USERNAME, username);
        return TOKEN_PREFIX + createToken(claims);
    }

    /**
     * 验证token是否有效
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        return isTokenExpired(token);
    }

}
