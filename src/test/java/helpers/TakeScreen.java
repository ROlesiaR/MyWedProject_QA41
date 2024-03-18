package helpers;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static config.BaseTest.getDriver;

public class TakeScreen {
    @Attachment (value = "Failure screenshot", type = "image/png")
    public  static  byte[] takeScreenshot(String testMain){
        try{ String screenshotName =  testMain+"_"+System.currentTimeMillis()+".png";
            File screnshotFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screnshotFile,new File("screenshots/"+screenshotName));
            return Files.readAllBytes((Paths.get("screnshorts\\"+screenshotName)));
        }catch(IOException e){
            return null;
        }
    }
}
