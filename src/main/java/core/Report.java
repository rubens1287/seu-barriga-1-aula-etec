package core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Report extends DriverManager{

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreeShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
