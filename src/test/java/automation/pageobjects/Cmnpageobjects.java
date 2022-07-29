package automation.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class Cmnpageobjects {

	private static final Logger logger=LogManager.getLogger(Cmnpageobjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;

	          //locators
	        private By LogoImg=By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"); 
	       // private By LogoImg=By.xpath("//img[@class='logo img-responsive']");
			private By SignInBtn=By.xpath("//a[@class='login']");
			private By SearchBox=By.xpath("//input[@placeholder='Search']");
			private By productsList=By.xpath("//div[@id='block_top_menu']/ul/li"); 
			private By SearchProdListDress=By.xpath("//div[@class='ac_results']//li");
			private By twitterlink=By.xpath("/html/body/div/div[3]/footer/div/section[1]/ul/li[2]/a");
			private By TwitterAccName= By.xpath("//div[@class='css-1dbjc4n r-6gpygo r-14gqq1x']//span/span");
			
			//private By TwitterAccName=By.xpath("//div[@dir='auto']//span[text()='Selenium Framework'])[1]");
			private By emailBox=By.xpath("//input[@id='newsletter-input']");
			private By sendBtn=By.xpath("//button[@name='submitNewsletter']");
			private By succesefulSubMsg=By.xpath("//p[@class='alert alert-success']");
			private By failSubMsg= By.xpath("//p[@class='alert alert-danger']");
	
			String ExpectedUrl="http://automationpractice.com/index.php";
			String emailId= "shamalgbhalerao123@gmail.com";
			String successedSubMsg= " Newsletter : You have successfully subscribed to this newsletter.";
			String failSubMessage= " Newsletter : This email address is already registered.";
			
			  //constructor
			public Cmnpageobjects(WebDriver driver,Scenario scn)
			{
				this.driver=driver;
				this.scn=scn;
			}

			//page methods
			public void URLvalidationTest() 
			{
				String ExpectedUrl="http://automationpractice.com/index.php";
				Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
				scn.log("URL validation successful. Actual URL :" + driver.getCurrentUrl());
				logger.info("URL validation successful. Actual URL :" + driver.getCurrentUrl());
			}
			
			public void landingPagetitleValidation()
			{
				String ExpectedTitle="My Store";
				  Assert.assertEquals(ExpectedTitle, driver.getTitle());
				  scn.log("Title validation successful. Actual Title :" + driver.getTitle());
				  logger.info("Title validation successful. Actual Title :" + driver.getTitle());
			}

			   public void productCategoryList()
			    {
			    	List <WebElement> prodCategoryList =driver.findElements(productsList);
			    	Assert.assertEquals(false, prodCategoryList.isEmpty());
			    	logger.info("Display the product category list,count of list is: "+ prodCategoryList.size());
			    	scn.log("Product category is displayed on page with count : "+ prodCategoryList.size());
			    }
			    
	
			    public void validateProdCategory(List<String> prodList)
			    {
			    	List <WebElement> prodCategoryList =driver.findElements(productsList);
			    	{
			    		for(int i=0; i< prodCategoryList.size(); i++)
			    		{
			    			if(prodCategoryList.get(i).getText().equals(prodList.get(i).toString()))
			        		{
			        			Assert.assertTrue(true);
			        			logger.info(prodCategoryList.get(i).getText()+ " is matched with expected "+ prodList.get(i).toString());
			        		}
			    			else
			    			{
			    				Assert.fail();
			        			logger.fatal(prodCategoryList.get(i).getText()+ " is not matched with expected "+ prodList.get(i).toString());
			    			}
			    		}
			    		logger.info("Validate the product category with expected datatable");
			    	}
			    }	

			
			   public void countOfProdCategory(int prodCount)
			   {
				   List <WebElement> prodCategoryList =driver.findElements(productsList);
				   Assert.assertEquals(prodCount, prodCategoryList.size());
				   logger.info("validate the Size of product category, size is: "+ prodCategoryList.size());
				   scn.log("validate the Size of product category, size is: "+ prodCategoryList.size());
			   }
			   
			
			
			
			public void logoDisplayTest()
			{
				WebElement logo =driver.findElement(LogoImg);
		    	Assert.assertEquals(true, logo.isDisplayed());
		    	logger.info("Display the logo on landing page");
		    
			}
			public void logHeighTtest()
			{
				WebElement ExeLogoHeight=driver.findElement(LogoImg);
			    Assert.assertEquals("99",ExeLogoHeight.getAttribute("height"));
			    scn.log("Landing page logo height is 99");
			    logger.info("Landing page logo height is 99");	
			}

			public void logoWidthTest()
			{
				
				//String ExpLogoWidth   ="350";
				WebElement ExpLogoWidth=driver.findElement(LogoImg);
		        Assert.assertEquals("350",ExpLogoWidth.getAttribute("width"));
				 scn.log("Landing page logo width is 350");
				 logger.info("Landing page logo width is 350");	
			}

			public void clickOnsigninBtn()
			{
				WebElement signIn =driver.findElement(SignInBtn);
				wait= new WebDriverWait(driver,20);
		    	wait.until(ExpectedConditions.elementToBeClickable(signIn));
		    	signIn.click();
			}
			
			public void validateSignInpageTitle()
			{
				String ExpSigninPageTitle="My Store";
				  Assert.assertEquals(ExpSigninPageTitle, driver.getTitle());
				  scn.log("Sign in page title is :" + driver.getTitle());
				  logger.info("Sign in page title is :" + driver.getTitle());
			}
			
			public void searchForProductDress()
			{
				List<WebElement> allProduct = driver.findElements(SearchProdListDress); //SearchProdListDress
				System.out.println(allProduct.size());
		        logger.info("Number of products searched: " + allProduct.size());
			}

		public void productList()
		{
			WebElement SearchBoxElement=driver.findElement(SearchBox);
			 logger.info("Created a webelement for searchbox");
			 Assert.assertEquals(true, SearchBoxElement.isEnabled());
			 scn.log("Search box is enabled");
			 logger.info("Search box is enabled");
			 SearchBoxElement.sendKeys("Dress"); 
			 logger.info("Sent product Dress in searchbox");
		}

		public void productCountResult() 
		{
			int count=0;
			List<WebElement>ResultCount=driver.findElements(SearchProdListDress);
			System.out.println(ResultCount.size());
			
			logger.info(" list of suggested products contains product name as: ");
	    	scn.log("Validate the list of suggested products ");
	        for(int i=0; i< ResultCount.size(); i++)
	    	{
	    		if(ResultCount.get(i).getText().contains(SearchProdListDress.toString()))
	    		{
	    			Assert.assertEquals(true,ResultCount.get(i).getText().contains(SearchProdListDress.toString()));
	    			logger.info(ResultCount.get(i).getText());
	        		scn.log(i+1 +". "+ ResultCount.get(i).getText());
	        		count++;
	        	}
	    	}
	        
	    
	    	logger.info("Total number of product is: "+ count);
	    	scn.log("Total number of product is: "+ count);
	    	
		}
		
		public void clickOnTwitterLink() 
		{
			
			WebElement twitterElement=driver.findElement(twitterlink);
			 logger.info("Created webElement for twiter");
			 twitterElement.click();
			   logger.info("Click on twitter logo");
			   
		}
		
		
		public void twitterAcctPage()
		{
			
			Set<String> handles = driver.getWindowHandles(); 
		     Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
		     String landingpage = it.next();//gives the parent window id
		     String twiterpage = it.next();
		     driver.switchTo().window(twiterpage);
		    logger.info("Window switched to twitter page");
		    
		    WebElement TwitterAccountElement=driver.findElement(TwitterAccName);
		    logger.info("Created WebElement for Twitter Account name");
		    Assert.assertEquals("Selenium Framework", TwitterAccountElement.getText());
		    scn.log("Twitter Account name is :" + TwitterAccountElement.getText() );
		    logger.info("Twitter Account name is :" + TwitterAccountElement.getText());
		}
		
		
		
		public void newsLetterTxBox()
		{
			WebElement newsLetterTxBox = driver.findElement(emailBox);
		}	
		
		public void enterEmailId()
	    {
	    	WebElement newsLetterTextBox =driver.findElement(emailBox);
	    	newsLetterTextBox.sendKeys(emailId);
	    	logger.info("Enter emailId in newsletter text box");
	    	scn.log("Enter emailId in newsletter text box");
	    }


	    public void clickOnProceedBtn()
		       {
		    	WebElement proceedButton= driver.findElement(sendBtn);
		    	proceedButton.click();
		    	logger.info("Click on proceed button");
		    	scn.log("Click on proceed button");
		       }
		
		public void subscriptionMsg()
		
		  {
			  try {
			        WebElement subscriptionMsg= driver.findElement(succesefulSubMsg);
			        logger.info("Message for successful email subscription : "+ subscriptionMsg.getText());
			        scn.log("Message for successful email subscription : "+ subscriptionMsg.getText());
			      } 
			  
			  catch(Exception e)
			  {
			    	WebElement failSubscriptionMsg= driver.findElement(failSubMsg);
			    	logger.info("Message Text failed email subscription: "+failSubscriptionMsg.getText());
			    	scn.log("Message text for failed email subscription: "+failSubscriptionMsg.getText());
			   }
			  
			    

		}
		
		public void validateSubscriptionMsg()
	    {
		    try 
		    {
		     WebElement subscriptionMsg= driver.findElement(succesefulSubMsg);
			 subscriptionMsg.getText().equals(succesefulSubMsg);
			 logger.info("Validate the message for successful email subscription is: "+ subscriptionMsg.getText());
			 scn.log("Validate the message text for successful email subscription is: "+ subscriptionMsg.getText());
			} 
		    catch(Exception e)
		    {
		     WebElement failSubscriptionMsg= driver.findElement(failSubMsg);
		     failSubscriptionMsg.getText().equals(failSubMsg);
		     logger.info("Validate the message text for failed email subscription is: "+failSubscriptionMsg.getText());
		     scn.log("Validate the message text for failed email subscription is : "+failSubscriptionMsg.getText());
		    }
	    }
      
		
}
		
	

