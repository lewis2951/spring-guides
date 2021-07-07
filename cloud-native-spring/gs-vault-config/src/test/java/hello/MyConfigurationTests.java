package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mark Paluch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyConfigurationTests {

    @Autowired
    MyConfiguration myConfiguration;

    @Test
    public void shouldContainConfigurationProperties() {

        assertThat(myConfiguration.getUsername()).isNotEmpty();
        assertThat(myConfiguration.getPassword()).isNotEmpty();
    }

}
