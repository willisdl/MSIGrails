package msigrails

class HTMLTagLib {

	static namespace = 'html'
	def render = {attrs ->
	
	def filePath = attrs.file
	
	if (!filePath) {
		throwTagError("'file' attribute must be provided")
	}
	
	def htmlContent = new File(filePath).text
		out << htmlContent
	}
}
