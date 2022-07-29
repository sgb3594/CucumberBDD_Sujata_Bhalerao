@tc @Healthcheck
Feature:E-commerce website for online shopping

Background:Navigated to url
Given User navigated to home application Url

#First#
@URLRedirection
Scenario: User naviaget to URL, User redirect to landing page with expected current URL
When User is on landing page
Then Validate current URL of landing page with expected URL


#Second
@LandingPageTitle
Scenario: User able to open the browser,navigated to url and validate the Title
Given Landing page expected title is "My Store"

#Third
@ProductCatagory
Scenario: User able to open the browser,navigated to url
When User see the product category
And Validate product category as per expected product category list
|     WOMEN    |
|    DRESSES   |
|    T-SHIRTS  |
Then Size of product category should be 3 

#Fourth
@LandingPageLogo_validation
Scenario: User able to open the browser,navigated to url,landing page logo is displayed
Given  Landing page logo is displayed

#Fifth
@LandingPage_Logo_Height
Scenario: User able to open the browser,navigated to url and landing page logo height validated
Given Landing page logo height should be "99"

#Sixth
@LandingPage_Logo_Width
Scenario: User able to open the browser,navigated to url and landing page logo width validated
Given Landing page logo width should be "350"

#Seven
@SignInOnWebpage
Scenario: User navigated to url, User click On Sign in button
Then Sign in page title validated "My Store"

#Eight
@SearchProductList
Scenario: User search product and Validate the numbers of products available 
Given User search for product "Dress"
And User able to see the list of available products
Then User validate the number of product count 5


#Ninth
@TwitterAccountHandling
Scenario: User clicked on twitterlink and navigate to url
Given User clicked on twitter link
Then User able to see Twittwer account name "Selenium FrameWork"
 
#Tenth
@NewsLetterSubscribtion
Scenario: User enter email in NewsLetter and validate email subsciption is successful 
Given User see NewsLetter text box and procced button
When User enter email id in NewsLetter box and clicked on procced button
And User got a Text Message " "
Then Email subscription successful is validated