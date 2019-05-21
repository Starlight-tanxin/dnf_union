package com.tx.union.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.tx.union.core.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * DateTime Config
 *
 * @author zhangshuai
 * @date 2018/11/12 17:37
 */

@Configuration
public class DateTimeConfig {

    @Bean(name = "mapperObject")
    public ObjectMapper getObjectMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateFormatter.DATE_TIME));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateFormatter.DATE));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateFormatter.TIME));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateFormatter.DATE_TIME));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateFormatter.DATE));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateFormatter.TIME));
        // setSerializationInclusion(JsonInclude.Include.NON_NULL) json返回对象时，忽略null的字段（null值的字段不会返回）
        // registerModule(javaTimeModule) 注册时间转换模型
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).registerModule(javaTimeModule);
    }

    // *** 注册转换器  **//
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateFormatter.DATE_TIME);
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateFormatter.DATE);
            }
        };
    }

    @Bean
    public Converter<String, LocalTime> localTimeConverter() {
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String source) {
                return LocalTime.parse(source, DateFormatter.TIME);
            }
        };
    }

}
