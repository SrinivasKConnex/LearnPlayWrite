package baseTest;

import java.nio.file.Paths;
import java.util.Random;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class learnPlaywrite1 {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
//git lern
		
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		Random r = new Random();
		int n = r.nextInt(100);
		System.out.println(n);
		page.navigate("https://ecommerce-playground.lambdatest.io/");
		System.out.println(page.title());
		Locator loc = page.locator("//a[@role='button']//span[@class='title'][normalize-space()='My account']");
		loc.click();
		page.locator("//aside[@id='column-right']//a[2]").click();
		page.getByPlaceholder("First Name").fill("Shashikumar");
		page.getByPlaceholder("Last Name").fill("Kumar s");
		page.getByPlaceholder("E-Mail").fill("shashikumar.ss" + n + "@gmail.com");
		page.getByPlaceholder("Telephone").fill("9980823847");
		page.locator("//input[@id='input-password']").fill("Shashi@123");
		// page.getByPlaceholder("Password Confirm").fill("Shashi@123");
		page.locator("//input[@id='input-confirm']").fill("Shashi@123");
		page.locator("//label[@class='custom-control-label']").nth(0).click();
		page.locator("//label[@class='custom-control-label']").nth(2).click();
		page.locator("//input[@type='submit']").click();
		loc.click();
//		page.getByPlaceholder("E-Mail Address").fill("shashikumar.ss"+n+"@gmail.com");
//		page.getByPlaceholder("Password").fill("Shashi@123");
		// page.fill(null, null)
		// page.locator("//input[@value='Login']").click();

		page.locator("#entry_217832").click();
		page.locator("//span[normalize-space()='Phone, Tablets & Ipod']").click();
		String ss = page.locator("//div[@class='description']/p").textContent();
		System.out.println(ss);
		Thread.sleep(5000);

		 Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions()
	                .setPath(Paths.get("./snap/screenshot.png"));
		 page.screenshot(screenshotOptions);
	                
		page.close();
		browser.close();
		playwright.close();

	}
}