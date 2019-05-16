package com.tx.union;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author tanxin
 * @date 2019/5/13
 */
@MapperScan("com.tx.union.dao")
@SpringBootApplication
public class UnionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnionApplication.class, args);
    }


    /**
     * 开启分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
