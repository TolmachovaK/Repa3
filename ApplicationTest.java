
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
            $("[data-qa-node='currency-option']").selectOptionByValue("USD");
        }
    }
