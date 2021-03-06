<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Maritime Safety Information"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'nga.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'nga_stylesheet.css')}" type="text/css">
		
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
	<g:render template="/common/msiHeader" />
	<table style="border-spacing: 0; padding: 0; border: 0">
  		<tr>
    		<td style="width: 145px; background-color: #cccccc; border-spacing: 0; padding: 0; border: 0; vertical-align: top">
      			<g:render template="/common/msiLeftNav" />
    		</td>
    		<td style="width: 638px; border-spacing: 0; padding: 0; border: 0; vertical-align: top">
				<g:layoutBody/>
	  			<g:javascript library="application"/>
	  			<g:javascript src="form_object_utility.js" />
				<r:layoutResources />
    		</td>
  		</tr>
	</table>
			
	<div class="footer">
		<g:render template="/common/msiFooter" />
	</div>
	</body>
</html>
