package boAt;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	
	public AndroidDriver<AndroidElement>  driver;

	public AndroidDriver<AndroidElement> initCapabilities( )throws MalformedURLException, Throwable
	{
	
	// TODO Auto-generated method stub
	
		
	    
	     Properties prop = new Properties();
			
			//loading the location of data.properties file
			FileInputStream fi= new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\boAt\\src\\main\\resources\\data.properties");
			prop.load(fi);
			
			String deviceName=prop.getProperty("dName");         //get the device name from file
			String appLocation=prop.getProperty("appLoc");		//get the app location from file
	    
			DesiredCapabilities capabilities = new DesiredCapabilities(); // initiating the Desired capabilites
	     
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.APP, appLocation);
	        
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);    // passing those capabilities to Appium server
	    
			Thread.sleep(2000);
	   
	    return driver;
	 
	}


}
