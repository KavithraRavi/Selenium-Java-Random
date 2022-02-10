import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Role based -- permission based use case
		// category manager user -- go to the app --- add all the products
		//customer user ---go to the app---- place an order
		//admin user --- go to the app --- can see all the orders
		//seller user --- go to the app --- can see only the orders that are relevant
		//distributer user --- go to the app -- see only the respective order
		//delivery boy --- go to the app --- see only the order assigned for delivery
		//customer care user --- see the orders assigned
		
		//WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		System.out.println(getCredentialsMap());
		System.out.println(getCredentialsMap().get("customer"));
		
		String role = getRoleofuser();
		
		driver.findElement(By.name("username")).sendKeys(getUserName(role));
		driver.findElement(By.name("password")).sendKeys(getPassword(role));
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		
		Thread.sleep(2000);
		driver.close();
				
	}
	
	public static HashMap<String, String> getCredentialsMap()
	{
		HashMap<String, String> usermap=new HashMap<String, String>();
		
		usermap.put("customer", "naveenautomation:Test@123");
		usermap.put("admin", "admin:admin@123");
		usermap.put("distributer", "distrubuter:dist@123");
		usermap.put("seller", "sell:sell@123");
		usermap.put("deliveryboy", "deliveryboy:delivery@123");//duplicate keys are not allowed in hashmap but can have duplicate values
		
		return usermap;
	}
	
	public static String getRoleofuser()
	{
		String role="seller";
		return role;
	}
	
	public static String getUserName(String role)
	{
		String Credentials = getCredentialsMap().get(role);
		return Credentials.split(":")[0];
	}

	public static String getPassword(String role)
	{
		String Credentials = getCredentialsMap().get(role);
		return Credentials.split(":")[1];
	}
	
}
