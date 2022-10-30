import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationTest {

    @Test
    public void shouldOpenSite(){

        WebDriverManager.chromedriver().setup();
        open("https://next.privat24.ua");
        open("https://next.privat24.ua/money-transfer/card");
        $("[data-qa-node='numberdebitSource']").sendKeys("4552331448138217");
        $("[data-qa-node='expiredebitSource']").sendKeys("0524");
        $("[data-qa-node='cvvdebitSource']").sendKeys("926");
        $("[data-qa-node='firstNamedebitSource']").sendKeys("FirstName");
        $("[data-qa-node='lastNamedebitSource']").sendKeys("LastName");
        $("[data-qa-node='numberreceiver']").sendKeys("4004159115449003");
        $("[data-qa-node='firstNamereceiver']").sendKeys("FirstReceiver");
        $("[data-qa-node='lastNamereceiver']").sendKeys("LastReceiver");
        $("[data-qa-node='amount']").sendKeys("123");
        $("[data-qa-node='currency']").click();
        $("[title='USD']").click();
        $("[type='submit']").click();
        $("[data-qa-node='payer-card']").should(Condition.text("4552 3314 4813 8217"));
        $("[data-qa-node='payer-amount']").should(Condition.text("123"));
        $("[data-qa-node='payer-currency']").should(Condition.text("5.41 USD"));
        $("[data-qa-node='receiver-name']").should(Condition.text("FIRSTRECEIVER LASTRECEIVER"));
        $("[data-qa-node='receiver-card']").should(Condition.text("4004 1591 1544 9003"));
        $("[data-qa-node='receiver-amount']").should(Condition.text("123 USD"));
        $("[data-qa-node='receiver-currency']").should(Condition.text("0 USD"));
        $("[data-qa-node='total']").should(Condition.text("Разом до списання 128.41 USD"));

    }
}
