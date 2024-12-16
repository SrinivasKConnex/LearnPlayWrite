package baseTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class learnPlayWrite2 {
	public static void main(String[] args) {

		Playwright playWrite = Playwright.create();

		Browser browser = playWrite.chromium().launch(new LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://www.amazon.in/");

		page.getByPlaceholder("Search Amazon.in").fill("latest phone");

		page.locator("#nav-search-submit-button").click();

		page.locator("//span[normalize-space()='Samsung']").nth(2).click();
		Locator locaters = page.locator("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']");

		int n = locaters.count();
		System.out.println(n);

		for (int i = 0; i < n; i++) {
			String text = locaters.nth(i).textContent();
			System.out.println(text);
		}

	}

}
