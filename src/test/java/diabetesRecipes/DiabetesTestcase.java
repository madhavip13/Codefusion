package diabetesRecipes;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class DiabetesTestcase {

 		
		public static WebDriver driver;
		@Test
		public void DiabetesRecipies() throws InterruptedException, IOException  {
				
			
			//System.setProperty("webdriver.chrome.driver", "D:\\Sangee-Testing\\workspace\\CodeFusion-sangee\\src\\test\\resources\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();	
			driver  = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize();
			
				driver.get("https://www.tarladalal.com");
			    Actions action=new Actions(driver);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
				
				WebElement Recipies=driver.findElement(By.xpath("//ul[@id='nav']/li[1]")) ;
				WebElement Health=driver.findElement(By.xpath("//a[text()='Health']")) ;
				WebElement Diabetes=driver.findElement(By.xpath("//a[text()='Delicious Diabetic Recipes']"));
				
				
				
//	           driver.findElement(By.xpath("//div[text()='RECIPES']")).click();
//	           Thread.sleep(5000);
//	           driver.findElement(By.xpath("//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht167']")).click();
				
				action.moveToElement(Recipies).build().perform();
				wait.until(ExpectedConditions.visibilityOf(Health));
				action.moveToElement(Health).build().perform();
				wait.until(ExpectedConditions.visibilityOf(Diabetes));
				action.moveToElement(Diabetes).build().perform();
				
				Diabetes.click();
				/*WebElement searchtxt;
				searchtxt = driver.findElement(By.xpath("//div[@id='search']/input[@id='ctl00_txtsearch']"));
				searchtxt.click();
				// Thread.sleep(1000);
				searchtxt.sendKeys("diabetic vegetarian breakfast");
				WebElement submitbtn = driver.findElement(By.name("ctl00$imgsearch"));
				submitbtn.click();*/
				
	           List<WebElement> page = driver.findElements(By.xpath("//div[@style='text-align:right;padding-bottom:15px;']/a"));
	           int pagesize = page.size();
	           int Excelcolumn = DiabeticExcelReader.getLastColumn("Sheet1");
	           System.out.println("Starting column=" + Excelcolumn );
	           for (int j = 1; j <= pagesize; j++)
	           {
	        	  // driver.findElement(By.xpath("//div[@style='text-align:right;padding-bottom:15px;']/a["+j+"]")).click();
	        	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//div[@id='maincontent']/div[1]/div[2]/div[5]/a["+j+"]")));

  
	           List<WebElement> cards = driver.findElements(By.xpath("//div[@class='recipelist']/article/div[3]/span/a"));
	           int cardsize = cards.size();
	           System.out.println("number of cards=" + cardsize );
	           for (int i = 1; i <= cardsize; i++) {
	       		System.out.println(i);
	       		 
	       		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/article["+i+"]//a[@itemprop='url']")));
	       		String RecipeName = driver.findElement(By.xpath("//div/article["+i+"]//a[@itemprop='url']")).getText();
	       		Thread.sleep(2000);
	       		/*String RecipeName =  driver.findElement(By.xpath("//div[@class='recipelist']/article["+i+"]/div[3]/span/a")).getText();
	       		Thread.sleep(7000); 
	       		System.out.println("RecipeNames=" + RecipeName );*/
	       		
	       		
	       		String ID = driver.findElement(By.xpath("//div[@class='recipelist']/article["+i+"]/div[2]/span")).getText();
	       		String[] id1 = ID.split("\n");
				String id2 = id1[0];
				String[] id3 = id2.split("#");
				String id4 = id3[1];
				ID = id4;
				
	       		System.out.println("ID=" + ID );
	       	    driver.findElement(By.xpath("//div[@class='recipelist']/article["+i+"]/div[3]/span/a")).click();
	       	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recipelist']/article["+i+"]/div[3]/span/a"))).click();
	       	    String PreTime = driver.findElement(By.xpath("//p/time[@itemprop='prepTime']")).getText();
	       	    System.out.println("PreTime=" + PreTime );
	       	    String recipeCatogory=driver.findElement(By.xpath("//div[@id='recipe_tags']/a[3]")).getText();
	       	    System.out.println("Recipe Catogory   "+recipeCatogory);
	       	   // String morbityDeatils=driver.findElement(By.xpath("//a[text()='High Blood Pressure']")).getText();
	       	    String morbityDetails="Diabetes";
	       	    System.out.println("morbityDeatils  "+morbityDetails);
	       	    String foodCatogory=driver.findElement(By.xpath("//div[@id='recipe_tags']/a[1]")).getText();
	       	    System.out.println("food catogory  "+foodCatogory);
	       	    String cookingTime = driver.findElement(By.xpath("//p/time[@itemprop='cookTime']")).getText();
	       	    //System.out.println("cookingTime=" + cookingTime );
	       	    String IngreList = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();System.out.println("cookingTime=" + cookingTime );
	       	    System.out.println("IngreList=" + IngreList );
	       	    String PrepMethod = driver.findElement(By.xpath("//div[@id='ctl00_cntrightpanel_pnlRcpMethod']")).getText();
	       	    //System.out.println("PrepMethod=" + PrepMethod );
	       	    String NutriValue ="";
	    	    try {
	    	      NutriValue = driver.findElement(By.id("rcpnutrients")).getText();
	    	    System.out.println("cookingTime=" + cookingTime );
	    	    }
	    	    catch (Exception e){
	    	    	 NutriValue ="";
	    	    }
	       	    String URL = driver.getCurrentUrl();
	       	   
	       	    String[][] ExcludeCode= DiabeticExcelReader.getData("Sheet1");
			       	 int Exsize=ExcludeCode.length;
			       	System.out.println("Exsize=" + Exsize );
			       	boolean isElimIngredExists=false;
			       	for(int k=0;k<Exsize;k++)
					{
			       		//System.out.println("Exsize to string=" + ExcludeCode[k][0] );
			       		
			       		int t = IngreList.toLowerCase().indexOf(ExcludeCode[k][0].toLowerCase());
			       		if (t!=-1){
			       		System.out.println("Elim Matched " +ExcludeCode[k][0]);
			       		isElimIngredExists=true;
						break;
			       		}
			       		//else {
			       		//	System.out.println("Not match");
			       		//}
					}
			       	
		    	    String[][] AddCode= DiabeticExcelReader.getData("Sheet2");
			       	 int Addsize=AddCode.length;
			       	System.out.println("Exsize=" + Exsize );
			       	boolean isAddIngredientExists=false;
			       	for(int k=0;k<Addsize;k++)
					{
			       		//System.out.println("Exsize to string=" + AddCode[k][0] );
			       		
			       		int t = IngreList.toLowerCase().indexOf(AddCode[k][0].toLowerCase());
			       		if (t!=-1){
			       		System.out.println("Add Matched" + AddCode[k][0]);
			       		isAddIngredientExists=true;
						break;
			       		}
			       		//else {
			       		//	System.out.println("Not match");
			       		//}
					}
			       	
			       	if ((!isElimIngredExists) && (isAddIngredientExists)) {
			       		System.out.println("Added to excel "+RecipeName);
			       		DiabetesExcelWriter excelWriter = new DiabetesExcelWriter();
			       	excelWriter.WriteData("Sheet1", 0, Excelcolumn++, ID, RecipeName,recipeCatogory,foodCatogory, IngreList, PreTime, cookingTime, PrepMethod,
						NutriValue,morbityDetails, URL);
			       	}
			    driver.navigate().back();  
				
	          }
	           }	
		}
//		public static void main(String[] args) throws InterruptedException, IOException
//		{
//			
			//Hypertension ht = new Hypertension ();
			
			//ht.BloodPressureRecipies();
			
	//}
	}
	

