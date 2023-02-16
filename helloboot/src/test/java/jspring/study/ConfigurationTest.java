package jspring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        /**
         * configuration 클래스의 특징: @Bean이라는 애노테이션이 붙은 메소드를 가지고 잇음
         * 그 각각의 메소드들이 자바코드에 의해서 빈 오브젝트를 생성하고 다른 오브젝트의 관계를 설정하는 부분을 담당
         */

        // Bean1, 2 가 모두 Common이라는 bean을 의존하고 있다고 가정
        // Bean1  <-- Common
        // Bean2  <-- Common
        // 스프링에 등록되는 bean은 특별하지 않으면 싱글톤으로 등록됨
        // => bean1과 bean2가 의존하고 있는 Common이라는 bean 오브젝트는 동일한 오브젝트여야함

        Assertions.assertThat(new Common()).isNotSameAs(new Common());

        Common common = new Common();
        Assertions.assertThat(common).isSameAs(common);

        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();
        Assertions.assertThat(bean1.common).isNotSameAs(bean2.common);

    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();
        Bean1 proxybean1 = myConfigProxy.bean1();
        Bean2 proxybean2 = myConfigProxy.bean2();

        Assertions.assertThat(proxybean1.common).isSameAs(proxybean2.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();

            return this.common;
        }
    }


    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    private static class Common {
    }
}
