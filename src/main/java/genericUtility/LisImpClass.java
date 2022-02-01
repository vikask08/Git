package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.crm.comcast.genericutility.BaseAnnotationClass;

public class LisImpClass {
	public void onTestFailure(ITestResult result) {
		String faildTestNAme=result.getMethod().getMethodName();

		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseAnnotationClass.sDriver);

		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
         
		String systemDate=new Date().toString().replace(":", "_").replace(" ", "_");
		
		File destFile=new File("./ScreenShot/"+faildTestNAme+"_"+systemDate+".png");

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
		}

	}

}
