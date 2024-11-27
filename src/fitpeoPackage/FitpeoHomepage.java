package fitpeoPackage;

import java.io.File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FitpeoHomepage

{
	   public static WebDriver driver;
	   public String driverPath = "F:\\ALL STUDY FILES\\Chrome-Driver\\Driver\\chromedriver-win64\\chromedriver.exe";
	   public File src;
	   public FileInputStream fis;
	   public static Properties pro;
	   public static JavascriptExecutor jse;
	   
	   public void openUrl_Meth() throws Exception
	   {
		   FitpeoHomepage obj = new FitpeoHomepage();
		   src = new File("F:\\InterviewProject-Fitpeo\\FitpeoWorkspace\\FitpeoProject\\Repository.properties");
		   fis = new FileInputStream(src);
		   pro = new Properties();
		   pro.load(fis);
		   
		   System.setProperty("webdriver.chrome.driver", driverPath);
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   obj.Url(driver, pro.getProperty("Url"));
	   }
	   
	   public void Url(WebDriver driver , String Url)
	   {
		   driver.get(Url);
	   }
}
