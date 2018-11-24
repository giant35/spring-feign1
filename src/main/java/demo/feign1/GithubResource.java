/*
 *  copyright (c) thelook.cn
 */
package demo.feign1;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 老唐
 */
@FeignClient(name = "githubResource", url = "https://api.github.com")
public interface GithubResource {

    @GetMapping("/repositories")
    List<GithubRepo> findRepositories(@RequestParam(name = "since", required = false) String since);

    public static class GithubRepo {

        private int id;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "GithubRepo{" + "id=" + id + ", name=" + name + ", url=" + url + '}';
        }

    }

    public static class GithubUser {

        private int id;
        private String login;
        private String avatar_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        @Override
        public String toString() {
            return "GithubUser{" + "id=" + id + ", login=" + login + ", avatar_url=" + avatar_url + '}';
        }

    }
}
