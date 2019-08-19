package core;

import org.openqa.selenium.WebDriver;

public class ConfirmationPF {
	static String borwser = "firefox";
	public static void validate(WebDriver driver, String url) {		
		CommonPF.open(borwser, url);
		CommonPF.pageValidation("42.05 Element [Title]", CommonPF.pf_el_05);	
		}
}
