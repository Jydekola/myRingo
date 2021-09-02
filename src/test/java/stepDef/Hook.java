package stepDef;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Hook extends BaseUtil {
    private BaseUtil base;
    public Hook(BaseUtil base){
        this.base = base;
    }
    //Import the io.cucumber @Before
    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        base.driver = new FirefoxDriver();

    }

    @After
    public void teardown() throws IOException {
        takeScreenshot();
        base.driver.close();
//        base.driver.quit();

    }

    private void takeScreenshot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)base.driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File ("target/screenshot" + System.currentTimeMillis()+ ".png"));


    }
}
