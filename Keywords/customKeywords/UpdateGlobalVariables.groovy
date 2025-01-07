package customKeywords

import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

class UpdateGlobalVariables {

	@Keyword
	def updateGlobalVar(String varName, def newValue) {
		GlobalVariable[varName] = newValue
		println "Global Variable '${varName}' updated to: ${newValue}"
	}
}
