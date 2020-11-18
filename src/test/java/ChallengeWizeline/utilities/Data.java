package ChallengeWizeline.utilities;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class Data {
	 
	 @DataProvider (name = "login-user-credentials")
	 public Object[][] loginUserCredentials()
	 {
		 Object[][] data = new Object[1][0];
		 HashMap<String , String> userCredentials = new HashMap<String , String>();
		 
		 userCredentials.put("username", "standard_user");
		 userCredentials.put("password", "secret_sauce");
		 userCredentials.put("invalidUser", "invalid_user");
		 
		 data[0] = new Object[] {userCredentials};
		 
		 return data;
	 }
	 
	 @DataProvider (name = "user-information-checkout-page")
	 public Object[][] userInformation()
	 {
		 Object[][] data = new Object[1][0];
		 HashMap<String , String> userInformation = new HashMap<String , String>();
		 
		 userInformation.put("firstName", "Marty");
		 userInformation.put("lastName", "McFly");
		 userInformation.put("postalCode", "1985");
		 userInformation.put("emptyValue", "");
		 userInformation.put("firstNameError", "Error: First Name is required");
		 userInformation.put("lastNameError", "Error: Last Name is required");
		 userInformation.put("postalCodeError", "Error: Postal Code is required");
		 
		 data[0] = new Object[] {userInformation};
		 
		 return data;
	 }
	 
	@SuppressWarnings("unchecked")
	@DataProvider(name = "login-and-checkout-information")
	 public Object[][] loginCheckoutInformation()
	 {
		 HashMap<String , String> mergedInformation = new HashMap<String , String>();
		 mergedInformation.putAll((HashMap<String, String>) loginUserCredentials()[0][0]);
		 mergedInformation.putAll((HashMap<String, String>) userInformation()[0][0]);
		 
		 Object[][] data = new Object[1][];
		 data[0] = new Object[] {mergedInformation};
		 
		return data;
	 
	 }
				 
}
