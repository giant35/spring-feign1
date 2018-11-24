/*
 *  copyright (c) thelook.cn
 */
package demo.feign1;

import demo.feign1.GithubResource.GithubRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author 老唐
 */
@SpringBootApplication
@EnableFeignClients
public class App {

    @Autowired
    GithubResource res2;

    public static void main(String[] argv) {
        SpringApplication.run(App.class, argv);
    }

    @Bean
    public CommandLineRunner runner() {
        return (argv) -> {
            //final Object ret = res.wxappLogin("1111", null, null);
            final List<GithubRepo> repos = res2.findRepositories(null);
            System.out.println(repos);
        };

    }

}
