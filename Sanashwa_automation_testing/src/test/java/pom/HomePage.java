package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class HomePage extends AllVerifications {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ HOMEPAGE - HERO CAROUSEL
	// ============================================================

	@FindBy(css = "div#root")
	private WebElement pageRootContainer;

	private final By pageRootContainerBy = By.cssSelector("div#root");

	@FindBy(css = "div#carouselExampleDark")
	private WebElement heroCarousel;

	@FindBy(css = "div#carouselExampleDark .carousel-indicators button")
	private List<WebElement> heroCarouselIndicators;

	// ============================================================
	// ✅ HOMEPAGE ACTIONS
	// ============================================================

	public boolean verifyHomePageRootContainerIsDisplayedAndEnabled() {
		return verifyElementPresentAndVisible(pageRootContainer, "HomePage Parent Container");
	}

	public void clickHeroIndicator(int indexZeroBased) {
		if (indexZeroBased < 0 || heroCarouselIndicators == null || indexZeroBased >= heroCarouselIndicators.size()) {
			System.out.println("[HOMEPAGE] Invalid hero indicator index: " + indexZeroBased);
			return;
		}
		clickOnElement(heroCarouselIndicators.get(indexZeroBased), "Hero Indicator " + indexZeroBased);
	}

	

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyHomepageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyHomepageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}