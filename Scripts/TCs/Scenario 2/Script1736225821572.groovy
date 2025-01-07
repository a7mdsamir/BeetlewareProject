import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import customKeywords.UpdateGlobalVariables as UpdateGlobalVariables

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.urlLogin)

WebUI.maximizeWindow()

//WebUI.verifyElementPresent(findTestObject('Pages/Home page/greetWelcomet_Btn'), 0)
WebUI.click(findTestObject('Pages/Home page/signIn_Btn'), FailureHandling.STOP_ON_FAILURE)

String loginPage = WebUI.getText(findTestObject('Object Repository/Pages/LoginPage/loginPagetitle'))

WebUI.verifyMatch(loginPage, 'Customer Login', false)

WebUI.setText(findTestObject('Pages/LoginPage/txtEmail'), GlobalVariable.email)

WebUI.setText(findTestObject('Pages/LoginPage/txtPassword'), GlobalVariable.password)

WebUI.click(findTestObject('Pages/LoginPage/btnLogin'), FailureHandling.STOP_ON_FAILURE)

String login = WebUI.getText(findTestObject('Object Repository/Pages/Home page/homePagetitle'))

WebUI.verifyMatch(login, 'Home Page', false)

WebUI.click(findTestObject('Object Repository/Pages/Home page/ArrowMen_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pages/Categories/MenTop_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pages/Categories/CategoryArrow_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pages/Categories/Jacket_Btn'), FailureHandling.STOP_ON_FAILURE)

String filter = WebUI.getText(findTestObject('Object Repository/Pages/Categories/FilterJacket_Txt'))

WebUI.verifyMatch(filter, 'Jackets', false)

WebUI.click(findTestObject('Object Repository/Pages/Categories/SecondIndexJacket_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pages/Categories/Size_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pages/Categories/Color_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pages/Categories/AddToCart_Btn'), FailureHandling.STOP_ON_FAILURE)

String addToCartMsg = WebUI.getText(findTestObject('Object Repository/Pages/Categories/AddToCartMsg_Txt'))

WebUI.verifyMatch(addToCartMsg, 'You added Montana Wind Jacket to your shopping cart.', false)

WebUI.click(findTestObject('Object Repository/Pages/Categories/Cart_Btn'), FailureHandling.STOP_ON_FAILURE)

