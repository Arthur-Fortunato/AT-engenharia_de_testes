package br.com.infnet.ex04;

import br.com.infnet.ex04.pages.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutenticacaoTest extends BaseTest {
    @Test
    void deveTestarCadastroValido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        assertThat(driver.getCurrentUrl(), containsString("login"));

        String nome = "Ark" + Math.random();
        String email = "ark" + Math.random() + "@teste.com";
        login.preencherSignup(nome, email);

        SignupPage signup = new SignupPage(driver);
        signup.preencherFormularioCompleto();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        assertTrue(accountCreated.paginaCarregada());
        assertThat(accountCreated.obterMensagem(), is("ACCOUNT CREATED!"));
    }

    @Test
    void devePreencherLoginValido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        assertThat(driver.getCurrentUrl(), containsString("login"));

        String email = "arttest@gmail.com";
        String senha = "123456789";
        login.preencherLogin(email, senha);

        HomePageLogada loggedPage = new HomePageLogada(driver);
        assertTrue(loggedPage.usuarioLogado(),"O Usuário deveria estar logado.");
    }

    @Test
    void deveExibirErroComLoginInvalido() {
        HomePage home = new HomePage(driver);
        AutenticationPage login = home.clicarNoLinkSignup();
        login.preencherLogin("email_randomqnexiste@teste.com", "senhadoida");
        assertTrue(login.erroVisivel(), "Era pra aparecer a mensagem de erro 'Your email or password is incorrect!'");
    }

}
