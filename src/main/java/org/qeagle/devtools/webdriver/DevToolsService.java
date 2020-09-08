package org.qeagle.devtools.webdriver;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qeagle.devtools.services.ChromeDevToolsService;
import com.qeagle.devtools.services.ChromeService;
import com.qeagle.devtools.services.impl.ChromeServiceImpl;

public class DevToolsService {

	private static String getDebuggerAddress(WebDriver driver) {
		// Get the Google ChromeOptions
		Object capability = ((RemoteWebDriver) driver).getCapabilities().getCapability("goog:chromeOptions");
		@SuppressWarnings("unchecked")
		Map<String,String> chromeOptions = (Map<String,String>)capability;
		return chromeOptions.get("debuggerAddress");
	}

	public static ChromeDevToolsService getDevToolsService(WebDriver driver) {
		ChromeService chromeService = new ChromeServiceImpl(Integer.parseInt(getDebuggerAddress(driver).replaceAll("\\D","")));	
		ChromeDevToolsService devToolsService = chromeService.createDevToolsService();
		return devToolsService;
	}

	public static int getRemoteDebuggerPort(WebDriver driver) {
		return Integer.parseInt(getDebuggerAddress(driver).replaceAll("\\D",""));
	}
	
	public static String getRemoteDebuggerServer(WebDriver driver) {
		return getDebuggerAddress(driver).replaceAll("[^A-Za-z]+","").trim();
	}

}
