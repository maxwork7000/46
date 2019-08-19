package core;

import org.openqa.selenium.WebDriver;

public class SignUpPF {
	static String borwser = "firefox";
	public static void validate(WebDriver driver, String url) {
		CommonPF.open(borwser, url);
		CommonPF.pageValidation("01.01 Element [Quotes (dynamic)]", 	CommonPF.pf_el_01);
		CommonPF.pageValidation("02.02 Element [Current Location]", 	CommonPF.pf_el_02);
		CommonPF.pageValidation("03.03 Element [Weather Icon]", 		CommonPF.pf_el_03);
		CommonPF.pageValidation("04.04 Element [Quotes (dynamic)]", 	CommonPF.pf_el_04);
		CommonPF.pageValidation("05.05 Element [Title]",				CommonPF.pf_el_05);
		}
}
