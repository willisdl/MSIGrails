<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'nga_stylesheet.css')}"/>
<map id="topLogoMap" name="topLogoMap">
  <area shape="circle" coords="38,28,29" href="http://www1.nga.mil/" alt="Click to visit NGA home." target="_top">
  <area shape="rect" coords="74,0,314,15" href="http://www1.nga.mil/" alt="Click to visit NGA home." target="_top">
</map>

<table style="border:0; padding: 0; border-spacing: 0; width: 780px">
  	<tr style="background-color: black; padding-bottom: 0px">
		<td style="display: block"><img style="vertical-align: bottom" usemap="#topLogoMap" src="${resource(dir: 'images', file: 'nga_banner_top.gif')}" alt="Top portion of NGA banner."/></td>
	</tr>
</table>
<table style="border:0; padding: 0; border-spacing: 0; width: 778px">
  <tr>
    <td style="width: 143px; background-color: #cccccc">&nbsp;</td>
    <td style="text-align: right">
      <div class="siteControls">
        <table border="0" class="epi-font2" style="padding: 0; border-spacing: 0">
          <tr style="text-align: right">
            <td style="width: 400px" />
            <!-- Home link (to Maritime) -->
            <td style="white-space: nowrap"><a href="/MSIGrails" class="nga-headerLink">Home</a></td>

            <!-- FAQ link -->
            <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
            <td style="white-space: nowrap"><a href="#" class="nga-headerLink">FAQ</a></td>

            <!-- Contact Info link -->
            <td ><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt=" "  /></td>
            <td style="white-space: nowrap"><a href="#" class="nga-headerLink">Contact Info</a></td>

            <!-- Related Links link -->
            <td ><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt=" " /></td>
            <td style="white-space: nowrap"><a href="#" class="nga-headerLink">Related Links</a></td>


            <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="space" width="10" /></td>
          </tr>
        </table>
      </div>
    </td>
  </tr>
</table>
</html>