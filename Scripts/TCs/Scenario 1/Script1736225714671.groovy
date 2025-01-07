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

WebUI.click(findTestObject('Pages/Home page/createAccount_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Pages/Registration page/txtFirstname'), GlobalVariable.firstname)

WebUI.setText(findTestObject('Pages/Registration page/txtLastname'), GlobalVariable.lastname)

Random random = new Random()

def random3Digits = String.format('%03d', random.nextInt(1000))

println('random3Digits       ' + random3Digits)

String email = ('ah' + random3Digits) + '@gmail.com'

WebUI.setText(findTestObject('Pages/Registration page/txtEmail'), email)

//
//String updatedEmail = WebUI.getText(findTestObject('Pages/Registration page/txtEmail'))
println('updatedEmail       ' + email)

GlobalVariable.email = email

//
//UpdateGlobalVariables.updateGlobalVar(GlobalVariable.email , email )
WebUI.setText(findTestObject('Pages/Registration page/txtPassword'), GlobalVariable.password)

WebUI.setText(findTestObject('Pages/Registration page/txtConfirmPassword'), GlobalVariable.confirmPassword)

WebUI.click(findTestObject('Pages/Registration page/createAnAccount_Btn'), FailureHandling.STOP_ON_FAILURE)

String regMsg = WebUI.getText(findTestObject('Pages/Registration page/regMsg_Txt'))

WebUI.verifyMatch(regMsg, 'Thank you for registering with Main Website Store.', false)

WebUI.verifyElementPresent(findTestObject('Pages/Home page/greetWelcomet_Btn'), 0)

WebUI.click(findTestObject('Pages/Home page/actionSwitcht_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Pages/Home page/signOut_Btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pages/Home page/signIn_Btn'), FailureHandling.STOP_ON_FAILURE)

String loginPage = WebUI.getText(findTestObject('Object Repository/Pages/LoginPage/loginPagetitle'))

WebUI.verifyMatch(loginPage, 'Customer Login', false)

WebUI.setText(findTestObject('Pages/LoginPage/txtEmail'), email)

WebUI.setText(findTestObject('Pages/LoginPage/txtPassword'), GlobalVariable.password)

WebUI.click(findTestObject('Pages/LoginPage/btnLogin'), FailureHandling.STOP_ON_FAILURE)

String myAccount = WebUI.getText(findTestObject('Object Repository/Pages/Home page/myAccountPagetitle'))

WebUI.verifyMatch(myAccount, 'My Account', false)

