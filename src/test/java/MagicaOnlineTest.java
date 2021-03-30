import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagicaOnlineTest {
    @BeforeClass
    public static void InitialSetup() {
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
    }
    
    @Test
    public void testHeroSectionSubtitle() throws IOException {
        var file = new File("src/test/java/file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        var expectedHeroSubtitle = reader.readLine();
        reader.close();

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://magicaonline.com.br/");

        List<WebElement> elementsFound = chromeDriver.findElements(By.className("second-title"));
        WebElement heroSubtitleElement = elementsFound.get(0);
        var heroSubtitleText = heroSubtitleElement.getText();
        
        chromeDriver.quit();

        assertEquals(heroSubtitleText, expectedHeroSubtitle);
    }
}