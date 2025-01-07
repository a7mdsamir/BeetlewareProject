package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class Checkout {
	@Keyword
	def static void CheckoutShop(String firstName,String lastName,String companyName,String country,String address,String city,String postCode,String Phone){
		WebUI.click(findTestObject('Pages/Home page/signOut_Btn'))

		WebUI.waitForElementVisible(findTestObject('Pages/Home page/txtFirstname'), GlobalVariable.waitPresentTimeout)
		WebUI.setText(findTestObject('Pages/Home page/txtFirstname'), firstName)
		WebUI.setText(findTestObject('Pages/Home page/txtLastname'), lastName)
		WebUI.waitForElementVisible(findTestObject('Pages/Home page/inputCompanyName'), GlobalVariable.waitPresentTimeout)

		WebUI.setText(findTestObject('Pages/Home page/inputCompanyName'), companyName)

		Select2.selectOptionByLabel(findTestObject('Select2/select_single'), country)
		Select2.getAllOptionsLabel(findTestObject('Select2/select_single'))
		Select2.getSelectedOptionsLabel(findTestObject('Select2/select_single'))

		WebUI.setText(findTestObject('Pages/Home page/inputAddress'), address)

		WebUI.setText(findTestObject('Pages/Home page/inputCity'), city)

		WebUI.setText(findTestObject('Pages/Home page/homePagetitle'), postCode)

		WebUI.setText(findTestObject('Pages/Home page/inputPhone'), Phone)

		BlockUIDismissed.WaitBlockUIDismissed()

		WebUI.click(findTestObject('Pages/Home page/signIn_Btn'))

		BlockUIDismissed.WaitBlockUIDismissed()
	}

	@Keyword
	def static void CheckoutShopWithGlobalVariable(){
		CheckoutShop(GlobalVariable.firstName,GlobalVariable.lastName,GlobalVariable.companyName, GlobalVariable.country, GlobalVariable.address, GlobalVariable.city, GlobalVariable.postCode, GlobalVariable.Phone)
	}
}
