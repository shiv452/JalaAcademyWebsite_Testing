package Definations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.*;

public class WebsiteTesting {

	/*
	 *  				{Test Case 1}
	 * 
	 *  \\Validating the Functionality of the login Page//
	 * 
	 * List:
	 * 
	 * Open the Google Chrome Driver
	 * Open the JALA Academy Login Page
	 * Enter the User Name and Password 
	 * Click on the Login Button
	 * 
	 */

	//initialize the WebDriver 
	WebDriver driver;

	@Given("brower is open")
	public void brower_is_open() throws InterruptedException {
		System.out.println("Inside Step - Browser is open");


		// Get the current project directory path
		//String projectPath = System.getProperty("usr.dir");

		// Print the project path
		//System.out.println("Project path is: " +projectPath);

		// Set the Chrome_Driver property using the project path
		System.setProperty("webdriver.chrome.driver","/Users/shivamgoyal/eclipse-workspace/JalaAcademy_WebsiteTesting/src/test/resources/driver/chromedriver");

		// Open the Chrom_Driver
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		//wait time 0.5sec
		Thread.sleep(500);

	}

	@When("user is on Jala Academy login page")
	public void user_is_on_jala_academy_login_page() {
		System.out.println("Inside Step - User is on Jala Academy login Page");

		//Navigate to the login page
		driver.navigate().to("https://magnus.jalatechnologies.com/");

	}

	@And("user is type the username and password")
	public void user_is_type_the_username_and_password() throws InterruptedException {
		System.out.println("Inside Step - User is type the username and password");

		//type the E-mail 
		driver.findElement(By.name("UserName")).sendKeys("training@jalaacademy.com");

		//wait .5sec
		Thread.sleep(500);

		//Type the password
		driver.findElement(By.name("Password")).sendKeys("jobprogram");

		//wait .5sec
		Thread.sleep(500);

	}

	@Then("hit the login button")
	public void hit_the_login_button() throws InterruptedException {
		System.out.println("Inside step - User hit the login button");

		//click the login button
		driver.findElement(By.id("btnLogin")).click();

		//wait .5sec
		Thread.sleep(500);	

	}


	/*
	 * 						{Test Case 2}
	 * 
	 *  \\Validating the Home Page working or not//
	 * 
	 * 	List:
	 * 
	 * First Background Part will RUN "Login Page"
	 * 
	 * In the Hamburger menu Click the "Employee" tab
	 * Sub-link: "Employee" -- > "Create"
	 * 			Click on the Create tab
	 * Click on the Home Tab in the Hamburger menu
	 * 
	 * 
	 * 
	 */   


	@When("user click the employee tab")
	public void user_click_the_employee_tab() throws InterruptedException {
		System.out.println("Inside Step - Click the employees section");

		/*
		 * 
		 *  
		 *	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 *	WebElement employee_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Employee')]")));
		 *  employee_button.click();
		 *  
		 */

		/*     
		 * 
		 *      xapth: 			//a[contains(text(),'Employee')]
		 *  	xpath: 			//*[@id="MenusDashboard"]/li[2]/a
		 *		xpath: 			/html/body/div[2]/aside/section/ul/li[2]/a
		 *		cssSelector: 	#MenusDashboard > li:nth-child(2) > a
		 *  
		 *  
		 */

		//click the menu and select the Employee tab
		driver.findElement(By.cssSelector("#MenusDashboard > li:nth-child(2) > a")).click();

		//Wait time .5s
		Thread.sleep(500);
	}



	@And("user click the create tab")
	public void user_click_the_create_tab() throws InterruptedException {
		System.out.println("Inside Step - Click the create section");

		//click  on the create tab 
		driver.findElement(By.xpath("//*[\"MenuDashboard\"]/li[2]/ul/li[1]/a")).click();

		//Wait time .5s
		Thread.sleep(500);

	}

	@Then("user click the home")
	public void user_click_the_home() throws InterruptedException {
		System.out.println("Inside Step - Click the home section to get back in main page.");

		//Click the home page and redirect to the main page again.
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[1]/a")).click();

		//wait time .5s 
		Thread.sleep(500);

		//close the current window
		driver.close();
		driver.quit();

	}


	/*
	 * 						{Test case 3}
	 * 
	 * 	\\Validate the form page and it's functionality//
	 * 
	 * 	List:
	 * 		
	 * First Background part will RUN
	 * 		=> Login Page -- > "Hamburger Menu" -- > Employee -- > Create
	 * Now, in the form page fill all the detail
	 * 	=> First Name -- > Last Name -- > Email ID -- > Mobile Number -- > DOB(Date Of Birth) -- > Address 
	 * 	-- > Country {Checking the Functionality of CheckBox as Well}  -- > City -- > Skills --> Save Button.
	 * 
	 * 
	 */


	@When("user click the create form tab")    
	public void user_click_the_create_form_tab() throws InterruptedException{
		System.out.println("Inside Step - User Clicks the from tab");

		//click the menu and select the Employee tab
		driver.findElement(By.cssSelector("#MenusDashboard > li:nth-child(2) > a")).click();

		//Wait time .5s
		Thread.sleep(500);

		//click  on the create tab 
		driver.findElement(By.xpath("//*[\"MenuDashboard\"]/li[2]/ul/li[1]/a")).click();

		//Wait time .5s
		Thread.sleep(500);	


	}

	@And("user type the First Name")
	public void user_type_the_first_name() throws InterruptedException {
		System.out.println("Inside Step - User types First Name");

		//fill the first name section
		driver.findElement(By.id("FirstName")).sendKeys("Shivam");

		//waiting time .5sec
		Thread.sleep(500);

	}

	@And("user type the Last Name")
	public void user_type_the_last_name() throws InterruptedException {
		System.out.println("Inside Step - User type the Last Name");

		//fill the last name section
		driver.findElement(By.id("LastName")).sendKeys("Goyal");

		//waiting time .5sec
		Thread.sleep(500);
	}

	@And("user type the Email")
	public void user_type_the_email() throws InterruptedException {
		System.out.println("Inside Step - User Types the Email - ID");

		//fill the email id section
		driver.findElement(By.id("EmailId")).sendKeys("shivamgoyal452@gmail.com");;

		//waiting time .5sec
		Thread.sleep(500);

	}

	@And("user type the Mobile Number")
	public void user_type_the_mobile_number() throws InterruptedException {
		System.out.println("Inside Step - User types the mob number");

		//fill the Mobile Number Section
		driver.findElement(By.id("MobileNo")).sendKeys("7500225843");;

		//waiting time .5sec
		Thread.sleep(500);

	}

	@And("user select the Date of Birth")
	public void user_select_the_date_of_birth() throws InterruptedException {
		System.out.println("Inside Step - User select the DOB");

		//fill the DOB section
		driver.findElement(By.id("DOB")).sendKeys("28/09/1999");

		//waiting time .5sec
		Thread.sleep(500);

		//click the Gender Radio tab.
		driver.findElement(By.id("rdbMale")).click();

		//waiting time .5sec
		Thread.sleep(500);

	}

	@And("user type the Address")
	public void user_type_the_address() throws InterruptedException {
		System.out.println("Inside Step - user type the address");

		//fill the address section
		driver.findElement(By.id("Address")).sendKeys("C#6, 1st Main Rd, Ramagiri, Mugesh Pallya, Old Air Port Road, Near Shivohm Temple, 560017.");

		//Waiting time .9sec
		Thread.sleep(900);

	}

	@And("user select the Country")
	public void user_select_the_country() throws InterruptedException {
		System.out.println("Inside Step - user select the country");

		//Select the Country from Select attribute and Option attribute, Click on India among others'.

		/* Both code are working fine. In below line of code, I intensely target the particular path
		 	//Click the Country 
			driver.findElement(By.id("CountryId")).click();

			//waiting time 3sec
			Thread.sleep(3000);

			//find the India option and click on it, using XPATH.
			WebElement option = driver.findElement(By.xpath("//option[@value='1']"));
			option.click();

			//wait time 4sec
			Thread.sleep(4000);
		 */

		/*
		 * In below line of code, I used different method by using .selectByVisibleText
		 * 
		 */

		//Code Here!
		WebElement dropDownCountry = driver.findElement(By.id("CountryId"));
		//create a new object
		Select select = new Select(dropDownCountry);
		select.selectByVisibleText("India");

		//wait time .9sec
		Thread.sleep(900);

		//Print the message if Country found in the list.
		if(dropDownCountry != null) {
			System.out.println("Country"+ dropDownCountry +"has been detected in the list!");
			//wait time .5s
			Thread.sleep(500);
		}else {
			System.out.println("Country"+ dropDownCountry +"has not been detected in the list!");
			//wait time .5s
			Thread.sleep(500);

			//close the current window and quit the program
			driver.close();
			driver.quit();
		}

		/*
		 * 
		 * 	To Checking the Functionality of the Check box name "Other City"
		 * 
		 */

		//Select the CheckBox and Click it
		WebElement CheckBox = driver.findElement(By.id("chkOtherCity"));
		CheckBox.click();

		//wait time .9sec
		Thread.sleep(900);

		//type the Other CityName
		WebElement CityName = driver.findElement(By.id("OtherCity"));
		CityName.sendKeys("Bangalore");

		//wait time .9sec
		Thread.sleep(900);

		//Clear The CityName
		CityName.clear();

		//wait time .9s
		Thread.sleep(900);

		//UnCheck the CheckBox
		CheckBox.click();

		//wait time .9sec
		Thread.sleep(900);
	} 

	@And("user select the City")
	public void user_select_the_city() throws InterruptedException {
		System.out.println("Inside Step - user select teh city");

		//select the City from Select attribute and option attribute, click DELHI among others'.

		/* Both code are working fine. In below line of code, I intensely target the particular path
		 * //click city 
			driver.findElement(By.id("CityId")).click();

			//click the DELHI using XPATH 
			WebElement option = driver.findElement(By.xpath("//*[@id=\"CityId\"]/option[3]"));
			option.click();

		 */

		//Code for Drop down option, and select the DELHI

		//Code Here!
		WebElement dropDownCity = driver.findElement(By.id("CityId"));
		//create a new object
		Select select = new Select(dropDownCity);
		select.selectByVisibleText("Delhi");

		//wait time .9sec
		Thread.sleep(900);

		//print the message,if the city found in the give drop down list!
		if(dropDownCity != null) {
			System.out.println("City"+ dropDownCity +"has been found in the list!");
			//wait time .9s
			Thread.sleep(900);

		}else {
			System.out.println("City"+ dropDownCity +"has not found in the list!");
			//wait time .9s
			Thread.sleep(900);
			//close the current window
			driver.close();
			driver.quit();
		}

	}

	@And("user select the Skills")
	public void user_select_the_skills() throws InterruptedException {
		System.out.println("Inside Step - User Select the skill");

		//Select the Skill QA-Automation among Other Skills
		WebElement Skills = driver.findElement(By.id("chkSkill_1"));
		Skills.click();

		//wait time .8sec
		Thread.sleep(800);
	}

	@Then("user hit the save button")
	public void user_hit_the_save_button() throws InterruptedException{

		//Save the file by simply clicking the save button
		WebElement Savebtn = driver.findElement(By.xpath("//*[@id=\"frmEmployee\"]/div[2]/button"));
		//WebElement Save button = driver.findElement(By.xpath("//button[contains(text(), 'Save')]"));
		Savebtn.click();

		//wait time .7sec
		Thread.sleep(700);

		//close the current window
		driver.close();
		driver.quit();
	}


	/*
	 * 									{Test - 4}
	 * 
	 * \\Validating and Checking the functionality of the search pages and it's tab's//
	 * 
	 * 	List: 
	 * 	
	 *  First RUN the Background Test Page
	 *  		=> Login -- > Employee -- > Create -- > Search
	 *  Click on the Search Tab
	 *  Click on the Name input and type the name 
	 *  Type the Search Button
	 *  If Page found then print the message
	 *  Click on the clear Button
	 *  Click on the mobile number and type the number
	 *  Click on the Edit button 
	 *  If page open then print the message
	 *  At last, click on the cancel button
	 * 	
	 */


	@When("click on the employee tab then search tab")
	public void click_on_the_employee_tab_then_search_tab() throws InterruptedException {
		System.out.println("Inside Step - RUN the Background code then click on the hamburger Menu --> Employee --> Search");

		//click the menu and select the Employee tab
		driver.findElement(By.linkText("Employee")).click();

		//Wait time .5s
		Thread.sleep(500);

		//click  on the search tab 
		driver.findElement(By.partialLinkText("Search")).click();

		//Wait time .5s
		Thread.sleep(500);	

	}

	@And("type the name in name input") 
	public void type_the_name_in_name_input() throws InterruptedException {
		System.out.println("Inside Step - click on the name input and type the name");

		//Type the Name in the EmployeesName Input section
		WebElement Name = driver.findElement(By.id("Name"));
		//Print the EmpName
		Name.sendKeys("Shivam");

		//Wait time .9sec
		Thread.sleep(900);

	}

	@And("click on seach button")
	public void click_on_seach_button() throws InterruptedException {
		System.out.println("Inside Step - Click on the seach button");

		//Click on the Search button
		driver.findElement(By.id("btnSearch")).click();

		//wait time .9sec
		Thread.sleep(900);

	}

	@And("if page found print the message")
	public void if_page_found_print_the_message() throws InterruptedException {
		System.out.println("Inside Step - if name matches then print the message");

		//Search Name using XPATH
		WebElement SearchElement = driver.findElement(By.xpath("//*[@id=\"tblEmployee\"]/tbody"));
		SearchElement.getText();

		if(SearchElement.getText().contains("Shivam"))
		{       
			// Continue with the test if "Name" found in the List.
			System.out.println("Name:"+ SearchElement +"found in the list...");
			//wait time .8s
			Thread.sleep(800);
		}
		else
		{
			// Exit from the loop if "Name" not found in the List.
			//stop testing
			System.out.println("Name not found in the list.");
			//wait time .7sec
			Thread.sleep(700);
			//Close the current window and terminate the program
			driver.close();
			driver.quit();

			/*
			 * You can use any one of these both works same.
			 * 
			 * driver.quit();
			 * System.exit(0);
			 */

			//Terminate the program
			//System.exit(0);
		}
	}

	@And("click on clear button")
	public void click_on_clear_button() throws InterruptedException {
		System.out.println("Inside Step - Click on the clear button");

		//click on the clear button
		driver.findElement(By.id("btnClear")).click();

		//sleep time .8sec
		Thread.sleep(800);
	}

	@And("type mobile number in input")
	public void type_mobile_number_in_input() throws InterruptedException {
		System.out.println("Inside Step - Click on the Mobile input tab and type the number");

		//type the Mobile Number in the Mobile No input
		WebElement MobNum = driver.findElement(By.id("MobileNo"));
		//give the input
		MobNum.sendKeys("7500225843");

		//wait time .8sec
		Thread.sleep(800);
	}

	@And("click on the search button")
	public void click_on_the_search_button() throws InterruptedException {
		System.out.println("Inside Step - Click on the seach button");

		//Click on the Search button
		driver.findElement(By.id("btnSearch")).click();

		//wait time .8sec
		Thread.sleep(800);

	}

	@And("click on the edit button")
	public void click_on_the_edit_button() throws InterruptedException {
		System.out.println("Inside Step - Click on the Edit Button");

		//Search for Name from the data using XPATH
		WebElement editBtn = driver.findElement(By.xpath("//*[@id=\"tblEmployee\"]/tbody/tr/td[9]/a[1]"));
		//Perform the action
		editBtn.click();

		//wait time .8sec
		Thread.sleep(800);


	}

	@And("if page open print the message")
	public void if_page_open_print_the_message() throws InterruptedException {
		System.out.println("Inside Step - If page open and find pertiular conatin then print the message");

		String text = "Employee Details";

		if(driver.getPageSource().contains("Employee Details")) {
			System.out.println("Text:"+ text + " is present.");
			Thread.sleep(800); //wait time .8s
		}else {
			System.out.println("Text:"+ text + " is not present.");
			Thread.sleep(800); //wait time .8s
			driver.close();
			driver.quit();
		}

	}

	@And("click on the cancel button")
	public void click_on_the_cancel_button() throws InterruptedException {
		System.out.println("Inside Step - Click on the cancel button");

		//Click on the Cancel button.
		driver.findElement(By.xpath("//*[@id=\"frmEmployee\"]/div[2]/a")).click();

		//waiting time .8sec
		Thread.sleep(800);

	}

	@Then("search name and delete the page")
	public void search_name_and_delete_the_page() throws InterruptedException {
		System.out.println("Inside Step - Search the name and delete it by clicking on the Delete btn");

		//Type the Name in the Employees_Name Input section
		driver.findElement(By.id("Name")).sendKeys("Shivam");
		//Wait time .9sec
		Thread.sleep(900);

		//Click on the search button to get the content
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(900); //wait time .9s

		//Click on the Delete Button
		WebElement delBtn = driver.findElement(By.linkText("Delete"));
		delBtn.click();
		Thread.sleep(900);

		//-------Delete Pop up window code-------

		driver.close();
		driver.quit();
	}


	/*
	 * 							{Test Case - 5}
	 * 
	 * \\Validating the more option tab and checking the functionality of sub tab multiple tabs//
	 * 
	 * 	List:
	 * 
	 * 	First RUN the background code
	 *  => Login -- > Navigation -- > Option {More} -- > Multiple Tabs
	 *  Click on the more tab
	 *  click on the sub-tab name "Multiple"
	 *  On the page of Multiple, click the the first tab name "Unlearning"
	 *  type the text in the box and check the functionality of the text box.
	 *  click the tab name "Plan to success"
	 *  type the text in the box and check the functionality of the text box.
	 *  The, click to the home and go back the main page
	 *  
	 */

	@When("the user click on the more tab")
	public void the_user_click_on_the_more_tab() throws InterruptedException {
		System.out.println("Inside Step - click on the more tab");

		//XPATH for the more tab
		WebElement moreTab = driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/a"));
		moreTab.click();	//action perform here!

		//wait for .5sec
		Thread.sleep(500);

	}

	@And("click on sub-tab multiple")
	public void click_on_sub_tab_multiple() throws InterruptedException {
		System.out.println("Inside Step - click on the sub-tab Multiple");

		//XPATH to the sub-tab --> and First sub link "Multiple"
		WebElement subTabMul = driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[1]/a"));
		subTabMul.click();		//action perform here!

		//wait for .5sec
		Thread.sleep(500);



	}

	@And("click on the Ways of Unlearning")
	public void click_on_the_ways_of_unlearning() throws InterruptedException {
		System.out.println("Inside Step - click on the ways of unlearning");

		//cssSelector for "Ways for Unlearning", click First.											-> action perform here!
		driver.findElement(By.cssSelector("#frmTabs > div > div > div > div > ul > li:nth-child(3) > a")).click();

		//wait time .5sec
		Thread.sleep(500);

	}

	@And("type the text_first")
	public void type_the_text_first() throws InterruptedException {
		System.out.println("Inside Step - Type the text");

		//type the text to check the input box
		WebElement textBox5 = driver.findElement(By.id("textbox5"));
		textBox5.sendKeys("Developing Creative Thinking."); //action perform here!

		//wait .5sec
		Thread.sleep(500);

		//type text to check the input box
		WebElement textBox6 = driver.findElement(By.id("textbox6"));
		textBox6.sendKeys("Developing Critical Thinking"); //action perform here!

		//wait .5sec
		Thread.sleep(500);

	}

	@And("click on the UnLearning")
	public void click_on_the_un_learning() throws InterruptedException {
		System.out.println("Inside Step - click on the unlearning");

		//cssSelector for "unlearning", click Second																-> action perform here!	
		driver.findElement(By.cssSelector("#frmTabs > div > div > div > div > ul > li:nth-child(2) > a")).click();

		//wait .5sec
		Thread.sleep(500);

	}

	@And("type the text_second")
	public void type_the_text_second() throws InterruptedException {
		System.out.println("Inside Step - Type the text");

		//type text to check the input box
		WebElement textBox3 = driver.findElement(By.id("textbox3"));
		textBox3.sendKeys("Overcoming Myths and Opening Our Eyes to Reality");

		//wait time .5sec
		Thread.sleep(500);

		//type the text to check the input box
		WebElement textBox4 = driver.findElement(By.id("textbox4"));
		textBox4.sendKeys("Critical examination of beliefs and ideologies");

		//wait time .5sec
		Thread.sleep(500);

	}

	@And("click on the Plan to Succeed")
	public void click_on_the_plan_to_succeed() throws InterruptedException {
		System.out.println("Inside Step - click on the plan to succeed");

		//cssSelector for "plan to succeed", click third 										-> action perform here!	
		//driver.findElement(By.cssSelector("#frmTabs > div > div > div > div > ul > li.active > a")).click();
		driver.findElement(By.linkText("Plan to Succeed")).click();

		//wait time .5sec
		Thread.sleep(500);

	}

	@And("type the text_third")
	public void type_the_text_third() throws InterruptedException {
		System.out.println("Inside Step - Type the text");

		//type the text to check the input box
		WebElement textBox1 = driver.findElement(By.id("textbox1"));
		textBox1.sendKeys("Unlearning to Learn: Embracing Continuous Learning in a Fast-Changing Technological Landscape");

		//wait time .5sec
		Thread.sleep(500);

		//type the text to check the input box
		WebElement textBox2 = driver.findElement(By.id("textbox2"));
		textBox2.sendKeys("Utilizing Knowledge and Experience to Secure a Job in Less Than 100 Days");

		//wait time .5sec
		Thread.sleep(500);

	}

	@Then("click to the home page tab")
	public void click_to_the_home_page_tab() throws InterruptedException {
		System.out.println("Inside Step - Go back to the home page");

		//XAPTH for click on the home tab
		WebElement homeTab = driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[1]/a"));
		homeTab.click(); //action perform here!

		//wait time .5sec
		Thread.sleep(500);

		//close the current WebDriver
		driver.close();
		driver.quit();

	}

	/*
	 * 						{Test Case - 6}
	 * 	\\Validating the more option tab and checking the functionality of sub tab menus//
	 * 
	 * List:
	 * 
	 *  First RUN the Background code first
	 *  => Login -- > more -- > menus -- > Testing tab -- > sub-list -- > JAVA -- > .NET -- > Database -- > menus tab -- > Home (Tab)
	 *  click on the more tab
	 *  click on the sub-tab menus
	 *  click on the Sub Menus
	 *  click on the first tab Testing
	 *  click on the sub-tab(Selenium, Manual Testing, DB Testing, Unit Testing)
	 *  click on the JAVA
	 *  click on the sub-tab(Adv Java, core java, Spring, Hibernate)
	 *  click on the .NET
	 *  click on the sub-tab(C#, ASP.NET, ADO.NET, MVN)
	 *  click on the Database
	 *  click on the sub-tab(SQL, My SQL, Oracle, H2)
	 *  click on the home tab
	 *  
	 */

	@When("user click on the more")
	public void user_click_on_the_more() throws InterruptedException {
		System.out.println("Inside Step - click on the Home Tab");

		//XPATH for the more tab
		WebElement moreTab = driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/a"));
		moreTab.click();	//action perform here!

		//wait for .5sec
		Thread.sleep(500);
	}

	@And("click on the menu")
	public void click_on_the_menu() throws InterruptedException {
		System.out.println("Inside Step - click on the Menu");

		//click on the Menu
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[2]/a")).click();

		//wait time .5sec
		Thread.sleep(500);
	}

	@And("click Sub-Menus")
	public void click_sub_menus() throws InterruptedException {
		System.out.println("Inside Step - click sub-Menu");

		//Click on the Sub Menus
		driver.findElement(By.linkText("Sub Menus")).click();

		//wait .5sec 
		Thread.sleep(500);

	}

	@And("click on the Testing")
	public void click_on_the_testing() throws InterruptedException {
		System.out.println("Inside Step - click on the Testing");

		//Sub Menus -- > Testing
		WebElement testingTab = driver.findElement(By.xpath("//*[@id=\"tab_2\"]/ul/li[1]/a"));
		testingTab.click();

	}

	@And("click on the drop down option Testing and print")
	public void click_on_the_drop_down_option_Testing_and_print() throws InterruptedException {
		System.out.println("Inside Step - click on the drop down stop and print");

		//------- Selenium --------
		//The code locates the web element with the ID "selbtn" on the web page and assigns it to a WebElement variable.
		WebElement seleniumTab = driver.findElement(By.id("selbtn"));
		seleniumTab.click();

		//wait time .5sec
		Thread.sleep(500);

		//The code locates the web element with the ID "label1" on the web page and assigns it to a WebElement variable.
		WebElement labelElement = driver.findElement(By.id("label1"));

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String seleniumMessage = labelElement.getText();        
		System.out.println("Selenium tab message: " + seleniumMessage);

		//--------- Manual Testing--------
		//The code locates the web element with the ID "manualbtn" on the web page and assigns it to a WebElement variable.
		WebElement manualTestingTab = driver.findElement(By.id("manualbtn"));
		manualTestingTab.click(); //action perform

		//wait time .5sec
		Thread.sleep(500);

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String manualTestingMessage = labelElement.getText(); 
		System.out.println("Manual Testing tab message: " + manualTestingMessage);

		//------------DataBase Testing--------
		//The code locates the web element with the ID "dbbtn" on the web page and assigns it to a WebElement variable.
		WebElement dbTestingTab = driver.findElement(By.id("dbbtn"));
		dbTestingTab.click(); 

		//wait time .5s
		Thread.sleep(500);

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String dbTestingMessage = labelElement.getText();
		System.out.println("DB Testing tab message: " + dbTestingMessage);

		//-----------Unit Testing -------------
		//The code locates the web element with the ID "unitbtn" on the web page and assigns it to a WebElement variable.
		WebElement unitTestingTab = driver.findElement(By.id("unitbtn"));
		unitTestingTab.click();  

		//wait time .5sec
		Thread.sleep(500);

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String unitTestingMessage = labelElement.getText();
		System.out.println("Unit Testing tab message: " + unitTestingMessage);
	}

	@And("click on the JAVA")
	public void click_on_the_java() throws InterruptedException {
		System.out.println("Inside Step - click on the JAVA");

		//Sub Menus -- > JAVA
		driver.findElement(By.xpath("//*[@id=\"tab_2\"]/ul/li[2]/a")).click();
		Thread.sleep(500); //wait time .5sec

	}

	@And("click on the drop down option Java and print")
	public void click_on_the_frop_down_option_Java_and_print() throws InterruptedException {
		System.out.println("Inside Step - click on the drop down option and print");

		//----------Adv JAVA ----------
		//The code locates the web element with the ID "advjavabtn" on the web page and assigns it to a WebElement variable.
		WebElement advjavaTab = driver.findElement(By.id("advjavabtn"));
		advjavaTab.click();

		Thread.sleep(500); //wait time .5s

		//The code locates the web element with the ID "label1" on the web page and assigns it to a WebElement variable.
		WebElement labelElement = driver.findElement(By.id("label1")); //message contain in label1

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String advjavaMessage = labelElement.getText();        
		System.out.println("Adv Java message: " + advjavaMessage);

		//------------Core JAVA---------
		//The code locates the web element with the ID "corejavabtn" on the web page and assigns it to a WebElement variable.
		WebElement CoreJavaTab = driver.findElement(By.id("corejavabtn"));
		CoreJavaTab.click(); //action perform

		Thread.sleep(500); //wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String CoreJavaMessage = labelElement.getText(); 
		System.out.println("Core Java tab message: " + CoreJavaMessage);

		//----------Spring----------
		//The code locates the web element with the ID "springbtn" on the web page and assigns it to a WebElement variable.
		WebElement dbTestingTab = driver.findElement(By.id("springbtn"));
		dbTestingTab.click(); 

		Thread.sleep(500); //wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String SpringMessage = labelElement.getText();
		System.out.println("Spring Message tab message: " + SpringMessage);

		//-----------Hibernate------------
		//The code locates the web element with the ID "hibernatebtn" on the web page and assigns it to a WebElement variable.
		WebElement unitTestingTab = driver.findElement(By.id("hibernatebtn"));
		unitTestingTab.click();  

		Thread.sleep(500);	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String HibernateMessage = labelElement.getText();
		System.out.println("Hibernate tab message: " + HibernateMessage);


	}

	@And("click on the .NET")
	public void click_on_the_net() throws InterruptedException {
		System.out.println("Inside Step - click on the .NET");

		//Sub Menus -- > .Net click
		driver.findElement(By.xpath("//*[@id=\"tab_2\"]/ul/li[3]/a")).click();
		Thread.sleep(500); //wait time .5sec

	}

	@And("click on the drop down option Net and print")
	public void click_on_the_frop_down_option_Net_and_print() throws InterruptedException {
		System.out.println("Inside Step - click on the drop down option and print");

		//---------C#----------
		//The code locates the web element with the ID "cbtn" on the web page and assigns it to a WebElement variable.
		WebElement cTab = driver.findElement(By.id("cbtn"));
		cTab.click();

		Thread.sleep(500); //wait time .5s

		//The code locates the web element with the ID "label1" on the web page and assigns it to a WebElement variable.
		WebElement labelElement = driver.findElement(By.id("label1")); //message contain in label1

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String cMessage = labelElement.getText();        
		System.out.println("C# message: " + cMessage);

		//-----------ASP.NET----------
		//The code locates the web element with the ID "aspbtn" on the web page and assigns it to a WebElement variable.
		WebElement ASP_NETTab = driver.findElement(By.id("aspbtn"));
		ASP_NETTab.click(); //action perform

		Thread.sleep(500); 	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String ASP_NETMessage = labelElement.getText(); 
		System.out.println("ASP.NET tab message: " + ASP_NETMessage);

		//----------ADO.NET--------------
		//The code locates the web element with the ID "adobtn" on the web page and assigns it to a WebElement variable.
		WebElement ADO_NETTab = driver.findElement(By.id("adobtn"));
		ADO_NETTab.click(); 

		Thread.sleep(500);	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String ADO_NETMessage = labelElement.getText();
		System.out.println("ADO.NET tab message: " + ADO_NETMessage);

		//------------MVC------------
		//The code locates the web element with the ID "mvcbtn" on the web page and assigns it to a WebElement variable.
		WebElement MVCTab = driver.findElement(By.id("mvcbtn"));
		MVCTab.click();  

		Thread.sleep(500); //wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String MVCMessage = labelElement.getText();
		System.out.println("MVC tab message: " + MVCMessage);
	}

	@And("click on the Database")
	public void click_on_the_database() throws InterruptedException {
		System.out.println("Inside Step - click on the database");

		//Sub Menus -- > DataBase
		driver.findElement(By.xpath("//*[@id=\"tab_2\"]/ul/li[4]/a")).click();
		Thread.sleep(500); //wait time .5s

	}

	@And("click on the drop down option Database and print")
	public void click_on_the_frop_down_option_Database_and_print() throws InterruptedException {
		System.out.println("Inside Step - click on the drop down option and print");

		//-----------SQL------------
		//The code locates the web element with the ID "sqlbtn" on the web page and assigns it to a WebElement variable.
		WebElement SQLTab = driver.findElement(By.id("sqlbtn"));
		SQLTab.click();

		Thread.sleep(500);	 //wait time .5s

		//The code locates the web element with the ID "label1" on the web page and assigns it to a WebElement variable.
		WebElement labelElement = driver.findElement(By.id("label1")); //message contain in label1

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String SQLMessage = labelElement.getText();        
		System.out.println("SQL message: " + SQLMessage);

		//------------My Sql----------
		//The code locates the web element with the ID "mysqlbtn" on the web page and assigns it to a WebElement variable.
		WebElement My_SqlTab = driver.findElement(By.id("mysqlbtn"));
		My_SqlTab.click(); //action perform

		Thread.sleep(500);	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String My_SqlMessage = labelElement.getText(); 
		System.out.println("My Sql tab message: " + My_SqlMessage);

		//----------Oracle--------------
		//The code locates the web element with the ID "oraclebtn" on the web page and assigns it to a WebElement variable.
		WebElement OracleTab = driver.findElement(By.id("oraclebtn"));
		OracleTab.click(); 

		Thread.sleep(500); //wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String OracleMessage = labelElement.getText();
		System.out.println("Oracle tab message: " + OracleMessage);

		//----------------H2------------------
		//The code locates the web element with the ID "h2btn" on the web page and assigns it to a WebElement variable.
		WebElement H2Tab = driver.findElement(By.id("h2btn"));
		H2Tab.click();  

		Thread.sleep(500);	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String H2Message = labelElement.getText();
		System.out.println("H2 Tab message: " + H2Message);	

	}

	@And("click on the Single Menus")
	public void click_on_the_single_menus() throws InterruptedException {
		System.out.println("Inside Step - click on the single menus");

		//click on the Single Menus
		driver.findElement(By.xpath("//*[@id=\"frmMenu\"]/div/div/div/div/ul/li[1]/a")).click();

		//wait time .5sec
		Thread.sleep(500);
	}

	@Then("click on the Testing, Java, .Net, Data Base")
	public void click_on_the_testing_java_net_data_base() throws InterruptedException {
		System.out.println("Inside Step - click on the Testing, JAVA, .NET, Database");

		//----------Testing---------
		//The code locates the web element with the ID "b1" on the web page and assigns it to a WebElement variable.
		WebElement Testing_Tab = driver.findElement(By.id("b1"));
		Testing_Tab.click();

		Thread.sleep(500);	//wait time .5sec

		//The code locates the web element with the ID "label1" on the web page and assigns it to a WebElement variable.
		WebElement labelElement = driver.findElement(By.id("panel1")); //message contain in label1

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String Testing_Message = labelElement.getText();        
		System.out.println("SQL message: " + Testing_Message);

		//----------Java---------
		//The code locates the web element with the ID "b1" on the web page and assigns it to a WebElement variable.
		WebElement Java_Tab = driver.findElement(By.id("b2"));
		Java_Tab.click();

		Thread.sleep(500);	//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String Java_Message = labelElement.getText();        
		System.out.println("Java message: " + Java_Message);

		//---------- .Net ---------
		//The code locates the web element with the ID "b1" on the web page and assigns it to a WebElement variable.
		WebElement Net_Tab = driver.findElement(By.id("b3"));
		Net_Tab.click();

		Thread.sleep(500);		//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String Net_Message = labelElement.getText();        
		System.out.println(".Net message: " + Net_Message);

		//----------DataBase---------
		//The code locates the web element with the ID "b1" on the web page and assigns it to a WebElement variable.
		WebElement DataBase_Tab = driver.findElement(By.id("b4"));
		DataBase_Tab.click();

		Thread.sleep(500);		//wait time .5s

		//this line of code retrieves the text content from the label1 element and assigns it to the manualTestingMessage variable as a string value.
		String DataBase_Message = labelElement.getText();        
		System.out.println("DataBase message: " + DataBase_Message);

		//close the current window
		driver.close();
		driver.quit();
	}


	/*
	 *     					{Test Case - 7}
	 *
	 * \\Validating the more option and checking the functionality of sub tab autocomplete//
	 * 
	 * List:
	 * 
	 * 	First RUN the Background code
	 * 	=> Login -- > {Navigation} -- > More -- > Sub-tab = Autocomplete
	 * 	click on the more tab option
	 * 	click on the multiple values
	 * 	type the tag name in the input box
	 *  click on the single values
	 *  type the tag name is the input box
	 *  click on the home tab
	 * 	
	 */

	@When("user click on the more1")
	public void user_click_on_the_more1() throws InterruptedException {
		System.out.println("Inside Step - click on the home tab");

		//XPATH for the more tab
		WebElement moreTab = driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/a"));
		moreTab.click();	//action perform here!

		//wait for .5sec
		Thread.sleep(500);
	}

	@And("click on the autocomplete tab")
	public void click_on_the_autocomplete_tab() throws InterruptedException {
		System.out.println("Inside Step - click on the autocomplete tab");

		//more -- > Autocomplete click
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[3]/a")).click();

		//wait time .5sec
		Thread.sleep(500);
	}

	@And("click on the multiple values")
	public void click_on_the_multiple_values() throws InterruptedException {
		System.out.println("Inside Step - click on the mutliple Values");

		//Autocomplet -- > :Multiple Values
		WebElement mulTab = driver.findElement(By.linkText("Multiple Values"));
		mulTab.click();

		//wait time .5sec
		Thread.sleep(500);

	}

	@And("type multiple language")
	public void type_multiple_language() throws InterruptedException {
		System.out.println("Inside Step - Type multiple Program language name");

		Actions mulDropdown = new Actions(driver);
		//XPATH -- > Multiple Values
		WebElement tagCode = driver.findElement(By.id("txtMultipleAutoComplete"));
		tagCode.click(); //action perform.

		//----------:Use twice for loop:------------
		//First: To display the list and go down till the desire point 
		//Second: Then, hit the Enter to select the drop down option.

		//-------- for loop start here!---------

		//----------------Select C ----------------
		for(int i=0; i <= 5; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ARROW_DOWN).perform();
			Thread.sleep(500); //wait time .5s
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for (int i = 0; i < 1; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ENTER).perform();
			Thread.sleep(500); // wait time .5s
		}

		//---------------Select C++ --------------------
		for(int i=0; i <= 6; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ARROW_DOWN).perform();
			Thread.sleep(500); //wait time .5sec
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for (int i = 0; i < 1; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ENTER).perform();
			Thread.sleep(500); // wait time .5s
		}

		//---------------Select Java --------------------
		for(int i=0; i <= 14; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for (int i = 0; i < 1; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ENTER).perform();
			Thread.sleep(500); // wait time .5s
		}

		//---------------Select JavaScript --------------------
		for(int i=0; i <= 15; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ARROW_DOWN).perform();
			Thread.sleep(500); 		//wait time .5s
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for (int i = 0; i < 1; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ENTER).perform();
			Thread.sleep(500); // wait time .5s
		}

		//---------------Select Python --------------------
		for(int i=0; i <= 19; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ARROW_DOWN).perform();
			Thread.sleep(500);	//wait time .5s
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for (int i = 0; i < 1; i++) {
			mulDropdown.sendKeys(tagCode, Keys.ENTER).perform();
			Thread.sleep(500); // wait time .5s
		}
		//---------- for loop end here -------------

		//after selecting all the desire option wait for 1sec.
		Thread.sleep(1000);
	}

	@And("click on the single values")
	public void click_on_the_single_values() throws InterruptedException{
		System.out.println("Inside Step - click on the single values");

		//Autocomplete -- > Single Values 
		driver.findElement(By.linkText("Single Values")).click();;

		//waiting time 0.5sec
		Thread.sleep(500);
	}

	@Then("type single language")
	public void type_single_language() throws InterruptedException {
		System.out.println("Inside Step - type the single program language");

		//Single input box
		WebElement single = driver.findElement(By.id("txtSingleAutoComplete"));
		single.sendKeys("p");	// send p
		Thread.sleep(500); //wait 0.5sec

		//Create a new Actions object 
		Actions singleDropdown = new Actions(driver);

		//--------- for loop start here! ------------

		//------------Select Python --------
		for(int i=0; i<=7; i++) {
			singleDropdown.sendKeys(single, Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
		}

		// Hit Enter multiple times
		// Spec1ify the number of times to hit Enter { i < 1}
		for(int i=0; i<=1; i++) {
			singleDropdown.sendKeys(single, Keys.ENTER).perform();
			Thread.sleep(500);
		}

		//----------For loop end here!----------

		//wait time 1sec
		Thread.sleep(1000);

		//close the current window
		driver.close();
		driver.quit();

	}

	/*			
	 * 								{Test Case - 7}
	 * 
	 * \\Validating the Collapsible Content page//
	 * 
	 * List:
	 * 
	 * 	=> Login -- > more --> Collapsible Content -- > Multiple Collapse (Test all four) -- > Single Collapse
	 * 
	 * 	click on the on the more drop down:
	 * 	click on the collasible content 
	 * 	click on the multiple collapes 
	 * 	click on the all in sequence and close in sequence
	 * 	click to open each time and close at the same time
	 * 	click on the Single collapes
	 * 	click on the first and close it
	 * 	click on the second and close it
	 * 	click on the third and close it
	 * 	click one-by-one all three
	 * 
	 */

	@And("click on the collapsible content")
	public void click_on_the_collapsible_content() throws InterruptedException	{
		System.out.println("Inside Step - click on the collapsible content Tab");

		//Click on the Collapsible content
		driver.findElement(By.partialLinkText("Collapsible Content")).click();
		Thread.sleep(500); 	// wait time .5s

	}

	@And("click to the multiple collapes")
	public void click_to_the_multiple_collapes() throws InterruptedException {
		System.out.println("Inside Step - click on the multiple collapes option");

		//Click on the multiple collapes
		driver.findElement(By.linkText("Multiple Collapse")).click();
		Thread.sleep(500); 	//wait time .5s

	}

	@And("click all collapes in sequence")
	public void click_all_collapes_in_sequence() throws InterruptedException {
		System.out.println("Inside Step - clcik all the collapes in sequence");

		//Click all the collapes in sequence

		//click on the first to open
		WebElement first = driver.findElement(By.id("headingFour"));
		first.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the second to open
		WebElement second = driver.findElement(By.id("headingFive"));
		second.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the third to open
		WebElement third = driver.findElement(By.id("headingSix"));
		third.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the fourth to open
		WebElement fourth = driver.findElement(By.id("headingSeven"));
		fourth.click();
		Thread.sleep(900); 	//wait time .9s

	}

	@And("click to close all collapes")
	public void click_to_close_all_collapes() throws InterruptedException {
		System.out.println("Inside Step - click to close all the collapes one by one");

		//Click all the collapes in sequence

		//click on the first to close
		WebElement first = driver.findElement(By.id("headingFour"));
		first.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the second to close
		WebElement second = driver.findElement(By.id("headingFive"));
		second.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the third to close
		WebElement third = driver.findElement(By.id("headingSix"));
		third.click();
		Thread.sleep(900); 	//wait time .9s

		//Click on the fourth to close
		WebElement fourth = driver.findElement(By.id("headingSeven"));
		fourth.click();
		Thread.sleep(900); 	//wait time .9s

	}

	@And("click first and close")
	public void click_first_and_close() throws InterruptedException {
		System.out.println("Inside Step - click first drop down and close it");

		//Click on the first to open and close after bit of second
		WebElement first = driver.findElement(By.id("headingFour"));
		first.click(); //action perform to open 
		Thread.sleep(900); 	//wait time .9s

		first.click(); //action perform to close
		Thread.sleep(300);


	}

	@And("click second and close")
	public void click_second_and_close() throws InterruptedException {
		System.out.println("Inside Step - click second drop down and close it");

		//Click on the second to open and close after bit of second
		WebElement second = driver.findElement(By.id("headingFive"));
		second.click(); //action perform to open 
		Thread.sleep(900); 	//wait time .9s

		second.click(); //action perform to close
		Thread.sleep(300);


	}

	@And("click third and close")
	public void click_third_and_close() throws InterruptedException {
		System.out.println("Inside Step - click third drop down and close it");

		//Click on the third to open and close after bit of second
		WebElement third = driver.findElement(By.id("headingSix"));
		third.click(); //action perform to open 
		Thread.sleep(900); 	//wait time .9s

		third.click(); //action perform to close
		Thread.sleep(300);

	}

	@And("click fourth and close")
	public void click_fourth_and_close() throws InterruptedException {
		System.out.println("Inside Step - click fourth drop down and close it");

		//Click on the fourth to open and close after bit of second
		WebElement fourth = driver.findElement(By.id("headingSeven"));
		fourth.click(); //action perform to open 
		Thread.sleep(900); 	//wait time .9s

		fourth.click(); //action perform to close
		Thread.sleep(300);

	}

	@Then("click to the single collapes")
	public void click_to_the_single_collapes() throws InterruptedException {
		System.out.println("Inside Step - click to the single collapes tab");

		//click on the Single Collapes
		driver.findElement(By.linkText("Single Collapse")).click();
		Thread.sleep(500); 	//wait time .5s

	}

	@And("click first and close1")
	public void click_first_and_close1() throws InterruptedException {
		System.out.println("Inside Step - click first drop down and close it");

		//Click on the first collapes
		WebElement first_Single = driver.findElement(By.id("headingOne"));
		first_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		first_Single.click(); //action peform to close
		Thread.sleep(300);


	}

	@And("click second and close2")
	public void click_second_and_close2() throws InterruptedException {
		System.out.println("Inside Step - click second drop down and close it");

		//Click on the second collapes
		WebElement second_Single = driver.findElement(By.id("headingTwo"));
		second_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		second_Single.click(); //action peform to close
		Thread.sleep(300);

	}

	@And("click third and close3")
	public void click_third_and_close3() throws InterruptedException {
		System.out.println("Inside Step - click third drop down and close it");

		//Click on the third collapes
		WebElement third_Single = driver.findElement(By.id("headingThree"));
		third_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		third_Single.click(); //action peform to close
		Thread.sleep(300);

	}

	@And("click all three in sequence")
	public void click_all_three_in_sequence() throws InterruptedException	{
		System.out.println("Inside Step - click all three one by one");

		//Click on the first collapes
		WebElement first_Single = driver.findElement(By.id("headingOne"));
		first_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		//Click on the second collapes
		WebElement second_Single = driver.findElement(By.id("headingTwo"));
		second_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		//Click on the third collapes
		WebElement third_Single = driver.findElement(By.id("headingThree"));
		third_Single.click(); //action perform to open
		Thread.sleep(900); 	//wait time .9s

		/*
		 	 String classAttribute = third_Single.getAttribute("class");

		if (classAttribute.contains("collapsed")) {
            System.out.println("First collapse element is collapsed");
        } else {
            System.out.println("First collapse element is expanded");
        }

		 */

		//close and quit the current window
		driver.close();
		driver.quit();
	}

	/*
	 * 				{Test Case - 8}
	 * 
	 * \\Validating the image uploading page and Verifying its functionality//
	 * 
	 * 	List:
	 * => Login -- > More -- > Image
	 * click and open image page
	 * upload the image file
	 * if image file uploaded then display message
	 * if image file not uploaded and error display then display error msg
	 * 
	 */

	@When("user click on the more subtab")
	public void user_clcik_on_the_more_subtab() throws InterruptedException {
		
	    driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/a")).click();
	    Thread.sleep(700);
	}
	
	@And("click on the Image sub-section")
	public void click_on_the_image_sub_section() throws InterruptedException {
		System.out.println("Inside Step - click on the image sub section");

		//Click on the image option
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[5]/a")).click();
		Thread.sleep(500); 	//sleep time .5s
	}

	@And("user upload the image file")
	public void user_upload_the_image_file() throws InterruptedException {
		System.out.println("Inside Step - Upload a image file!");
		
		//upload the Image file
		WebElement fileUpload = driver.findElement(By.id("file"));
		fileUpload.sendKeys("/Users/shivamgoyal/Desktop/utest quotes.png"); //image file path form desktop.
		Thread.sleep(700); //sleep time .7s
		
		
		//Check the file name
		WebElement fileName = driver.findElement(By.id("fileName"));
		//Check if the Image file name appears
		// Get the value of the file name input field
        String imageFileName = fileName.getAttribute("value");
        // Print the file name
        System.out.println("File Name: " + imageFileName);
        Thread.sleep(300); //sleep .3s

	}

	@And("click to the upload button")
	public void click_to_the_upload_button() throws InterruptedException {
		System.out.println("Inside Step - click on the uplaod btn");
	
		//Xpath for upload Button
		WebElement uploadBtn = driver.findElement(By.xpath("//*[@id=\"frmImages\"]/div/div/div[1]/div[3]/button"));
		uploadBtn.click(); //action perform
		
		Thread.sleep(500); //sleep time .5s
	}

	@And("display message if file is uploaded")
	public void display_message_if_file_is_uploaded() throws InterruptedException {
		System.out.println("Inside Step - display a message if file upload");

		//Display a message if image file get uploaded in the system.
		WebElement fileVerify = driver.findElement(By.id("divImages"));
		
		//Check if the file is uploaded on the page
		if(fileVerify.isDisplayed())
		{
		    // If the file is uploaded, retrieve the file name
			String fileNameVerify = fileVerify.getAttribute("value");
			System.out.println("Image File "+fileNameVerify +"is uploaded successfuly!");
		} else {
		    // If the file is not uploaded, display an error message
			System.out.println("Image File is not uploaded!");
		}
		
		Thread.sleep(500); //sleep time .5s

	}

	@Then("display message if error appear")
	public void display_message_if_error_appear() throws InterruptedException {
		System.out.println("Inside Step - display a message if image file is not get uploaded in the system and error message appear!");

		//some error message element to check
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));
		
		// Check if the error message appears
		if (errorMsg.isDisplayed()) {
		    // If the error message is displayed, retrieve the error message text
		    String errorMessage = errorMsg.getText();
		    System.out.println("Error message: " + errorMessage);
		}
		
		Thread.sleep(500); //sleep time .5s
	
		//close and quit the 
		driver.close();
		driver.quit();
	}




} // main




