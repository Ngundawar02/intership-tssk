package intership;

public class webdriver {

	public static void main(String[] args) {
		 selenium import webdriver
		from selenium.webdriver.common.by import By
		from selenium.webdriver.common.keys import Keys
		import time
		import unittest

		class LoginTestSuite(unittest.TestCase):
		    
		    @classmethod
		    def setUpClass(cls):
		        cls.driver = webdriver.Chrome()
		        cls.driver.maximize_window()
		        cls.driver.get("https://example.com/login")  # Replace with actual URL
		        time.sleep(2)
		    
		    def test_valid_login(self):
		        """Test case for successful login with valid credentials"""
		        driver = self.driver
		        driver.find_element(By.NAME, "username").send_keys("validUser")
		        driver.find_element(By.NAME, "password").send_keys("validPassword")
		        driver.find_element(By.NAME, "login").click()
		        time.sleep(2)
		        
		        # Verify login success (modify as per your website)
		        self.assertIn("Dashboard", driver.title)
		    
		    def test_invalid_login(self):
		        """Test case for login failure with incorrect credentials"""
		        driver = self.driver
		        driver.find_element(By.NAME, "username").clear()
		        driver.find_element(By.NAME, "password").clear()
		        driver.find_element(By.NAME, "username").send_keys("wrongUser")
		        driver.find_element(By.NAME, "password").send_keys("wrongPassword")
		        driver.find_element(By.NAME, "login").click()
		        time.sleep(2)
		        
		        # Verify login failure message
		        error_message = driver.find_element(By.ID, "error").text
		        self.assertEqual(error_message, "Invalid username or password.")
		    
		    def test_empty_fields(self):
		        """Test case for login attempt with empty fields"""
		        driver = self.driver
		        driver.find_element(By.NAME, "username").clear()
		        driver.find_element(By.NAME, "password").clear()
		        driver.find_element(By.NAME, "login").click()
		        time.sleep(2)
		        
		        # Verify required field messages (modify as per your website)
		        error_message = driver.find_element(By.ID, "error").text
		        self.assertEqual(error_message, "Please fill out this field.")
		    
		    @classmethod
		    def tearDownClass(cls):
		        cls.driver.quit()

		if __name__ == "__main__":
		    unittest.main()

	}

}
