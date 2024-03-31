package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomInputGenerator {
	
	public String randomString(int minChar, int maxChar) {
		String generatedString = RandomStringUtils.randomAlphabetic(minChar, maxChar).toLowerCase();
		return generatedString;
	}
	
	public String randomEmail(int minChar, int maxChar) {
		String generatedEmail = RandomStringUtils.randomAlphanumeric(minChar, maxChar);
		return generatedEmail + "@gmail.com";
	}
	
	public String randomMobileNumber(int digits) {
		String generatedMobileNumber = "9"  + RandomStringUtils.randomNumeric(digits);
		return generatedMobileNumber;
	}
}
