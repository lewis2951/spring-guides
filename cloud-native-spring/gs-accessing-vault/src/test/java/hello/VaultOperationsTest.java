package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultOperationsTest {

    @Autowired
    private VaultOperations vaultOperations;

    @Test
    public void readShouldRetrieveVaultData() {

        VaultResponse response = this.vaultOperations.read("secret/github");

        assertThat(response.getData()).containsEntry("github.oauth2.key", "foobar");
    }

    @Test
    public void writeShouldStoreVaultData() {

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "john");
        credentials.put("password", "doe");

        this.vaultOperations.write("secret/database", credentials);

        VaultResponseSupport<Credentials> mappedCredentials = this.vaultOperations.read("secret/database", Credentials.class);

        assertThat(mappedCredentials.getData().getUsername()).isEqualTo("john");
        assertThat(mappedCredentials.getData().getPassword()).isEqualTo("doe");
    }

    static class Credentials {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
