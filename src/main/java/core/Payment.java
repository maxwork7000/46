package core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
public class Payment {

       static SafariDriver driver;

       public static void main(String[] args) throws InterruptedException {
              Logger.getLogger("").setLevel(Level.OFF);
              
              if (!System.getProperty("os.name").contains("Mac")) {

                     throw new IllegalArgumentException("Safari is available only on Mac");}

              String url = "http://alex.academy/exe/payment/index.html";

//            String url = "http://alex.academy/exe/payment/index2.html";

//            String url = "http://alex.academy/exe/payment/index3.html";

//            String url = "http://alex.academy/exe/payment/index4.html";

//            String url = "http://alex.academy/exe/payment/indexE.html";

              driver = new SafariDriver();
              
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

              ((WebDriver) driver).manage().window().maximize();

              ((WebDriver) driver).get(url);

              final long start = System.currentTimeMillis();          

              // "$1,654.55";

              String string_monthly_payment = ((WebDriver) driver).findElement(By.id("id_monthly_payment")).getText();

              String regex = "^"

                           + "(?:\\$)?"

                           + "(?:\\s*)?"

                           + "((?:\\d{1,3})(?:\\,)?(?:\\d{3})?(\\d{0,2})?)"

                           + "$";

              Pattern p = Pattern.compile(regex);

              Matcher m = p.matcher(string_monthly_payment);

              m.find();

                           // 1,654.55

              double monthly_payment = Double.parseDouble(m.group(1).replaceAll(",", ""));

                           // 1654.55 * 12 = 19854.60

double annual_payment = new BigDecimal(monthly_payment * 12).setScale(2, RoundingMode.HALF_UP).doubleValue();

                           // 19854.6

              DecimalFormat df = new DecimalFormat("0.00");

              String f_annual_payment = df.format(annual_payment);

((WebDriver) driver).findElement(By.id("id_annual_payment")).sendKeys(String.valueOf(f_annual_payment));

              ((WebDriver) driver).findElement(By.id("id_validate_button")).click();

              String actual_result = ((WebDriver) driver).findElement(By.id("id_result")).getText();

              final long finish = System.currentTimeMillis();

              System.out.println("String: \t" + m.group(0)); // capturing whole thing

              System.out.println("Annual Payment: " + f_annual_payment);

              System.out.println("Result: \t" + actual_result);

             System.out.println("Response time: \t" + (finish - start) + " milliseconds");

              ((WebDriver) driver).quit();

       }

}