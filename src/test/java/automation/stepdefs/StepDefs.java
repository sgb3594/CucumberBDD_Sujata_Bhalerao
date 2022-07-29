package automation.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.core.WebDriverFactory;
import automation.pageobjects.Cmnpageobjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	private static final Logger logger=LogManager.getLogger(StepDefs.class);
	WebDriver driver;
	String Base_Url="http://automationpractice.com/";
	WebDriverWait wait;
	Scenario scn;
	
	Cmnpageobjects cmnPageObjects;
	
	
	        //--Cucumber-Hooks--//
	
	@Before
	public void setUp(Scenario scn) throws Exception{
		this.scn = scn;
		
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser invoked.");
		
		cmnPageObjects  = new Cmnpageobjects (driver,scn);  //initialize object of pageobject class
		
	}
		

		@After(order=2)
		//Capture screenshot if test case got failed
		public void captureScreenshot(Scenario scn)
		{
			if(scn.isFailed())
			{
				TakesScreenshot srnshot= ((TakesScreenshot)driver);
				byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
				scn.attach(data, "image/png", "Name of failed step is: "+ scn.getName());
				scn.log("Attach a screenshot as step get failed");
			}
			else
			{
				scn.log("Test case get passed, no screenshot is captured");
			}
		}

		@After(order=1)
		public void cleanUp(){

			WebDriverFactory.quitDriver();
			scn.log("Browser is quit");
		}
		
//	@Given("User opened browser")
//	public void user_opened_browser() 
//	{
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		wait=new WebDriverWait(driver,20);
//	  
//	}

		@Given("User navigated to home application Url")
		public void user_navigated_to_home_application_url()
		{
			 driver.get(Base_Url); 
			   
			   scn.log("Browser navigated to URL :" + Base_Url);
			   logger.info("Browser navigated to URL :" + Base_Url);
			  
		}


		@When("User is on landing page")
		public void user_is_on_landing_page()
		{
			logger.info("User is on landing page after navigating to base URL");
		    scn.log("User is on landing page after navigating to base URL");
		}
		
		@Then("Validate current URL of landing page with expected URL")
		public void validate_current_url_of_landing_page_with_expected_url()
		{
			cmnPageObjects.URLvalidationTest();
		}


	

	@Given("Landing page expected title is {string}")
	public void landing_page_expected_title_is(String string)
	{
		cmnPageObjects.landingPagetitleValidation();
	}

	@When("User see the product category")
	public void user_see_the_product_category()
	{
		cmnPageObjects.productCategoryList();
		
	}
	

	@When("Validate product category as per expected product category list")
	public void validate_product_category_as_per_expected_product_category_list(List<String> prodList)
	{
		cmnPageObjects.validateProdCategory(prodList);
	}
	
	@Then("Size of product category should be {int}")
	public void size_of_product_category_should_be(Integer prodCount)
	{
		cmnPageObjects.countOfProdCategory(prodCount);
	}



  
 
  @Given("Landing page logo is displayed")
  public void landing_page_logo_is_displayed()
  {

	  cmnPageObjects.logoDisplayTest(); 
  }
    
  @Given("Landing page logo height should be {string}")
  public void landing_page_logo_height_should_be(String string) 
  {
	  cmnPageObjects.logHeighTtest();
		
  }
 
  @Given("Landing page logo width should be {string}")
  public void landing_page_logo_width_should_be(String string) 
  
  {  
	  cmnPageObjects.logoWidthTest();
  }
  
  @When("User click On Sign in button")
  public void user_click_on_sign_in_button() 
  {
     cmnPageObjects.clickOnsigninBtn();
  }

  @Then("Sign in page title validated {string}")
  public void sign_in_page_title_validated(String string) 
     {
      cmnPageObjects.validateSignInpageTitle();
     }

  @Then("Landing page title is {string}")
  public void landing_page_title_is(String string)
  {
	  cmnPageObjects.validateSignInpageTitle();
  }
  
  @Given("User search for product {string}")
  public void user_search_for_product(String string) 
  {
      cmnPageObjects.searchForProductDress();
  }

  @Given("User able to see the list of available products")
  public void user_able_to_see_the_list_of_available_products() 
  {
	 cmnPageObjects.productList();
  }

//  @Then("User validate the number of product available with result {string}")
//  public void user_validate_the_number_of_product_available_with_result(String string) 
//  {
//	  cmnPageObjects.productCountResult(String string); 
//  }
  
  @Then("User validate the number of product count {int}")
  public void user_validate_the_number_of_product_count(Integer int1) 
  {
	  cmnPageObjects.productCountResult();
  }
  
  @Given("User clicked on twitter link")
  public void user_clicked_on_twitter_link() 
  {
	  cmnPageObjects.clickOnTwitterLink(); 
  }
  

  @Then("User able to see Twittwer account name {string}")
  public void user_able_to_see_twittwer_account_name(String string) 
  {
      cmnPageObjects.twitterAcctPage();
  
  }

  @Given("User see NewsLetter text box and procced button")
  public void user_see_news_letter_text_box_and_procced_button() 
      {
      cmnPageObjects.newsLetterTxBox();
      }

  @When("User enter email id in NewsLetter box and clicked on procced button")
  public void user_enter_email_id_in_news_letter_box_and_clicked_on_procced_button()
      {
      cmnPageObjects.enterEmailId();
      cmnPageObjects.clickOnProceedBtn();
      }


 

  @And("User got a Text Message {string}")
  public void user_got_a_text_message(String string) 
     {
	  cmnPageObjects.subscriptionMsg();
	  }
  
  @Then("Email subscription successful is validated")
  public void email_subscription_successful_is_validated() 
  {
	  cmnPageObjects.validateSubscriptionMsg();
  }



  
  
}



	
	

