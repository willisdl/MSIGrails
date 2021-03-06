<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'nga_stylesheet.css')}"/>
<table class="nga-verticalNavBG" style="width: 145px; border: 0; padding: 0; border-spacing: 0; height: 100%">
<tbody style="background-color: rgb(204, 204, 204); font-family: Verdana, Geneva, sans-serif; font-size: .7em; text-decoration: none">
<tr>
  <td>
    <form name="searchForm" method="GET" action="javascript:redirectToSearch(document.searchForm.q.value);">
      <table class="nga-verticalNavBG" style="border: 0; cellpadding: 0; border-spacing: 0">
        <input name="site" value="my_collection" type="hidden">
        <input name="client" value="my_collection" type="hidden">
        <input name="output" value="xml_no_dtd" type="hidden">
        <tbody>

        <tr style="padding-left: 4px; padding-bottom: 1px;">
          <td class="nga-verticalNavText">Search NGA:</td>
        </tr>
        <tr style="padding-left: 2px; vertical-align: middle">
          <td><input title="Search Query Box" class="msi-verticalNavInputElement" size="7" name="q" maxlength="255"
                     value="" type="text"> <input title="Start Search" class="nga-verticalNavButton" name="btnG" value="Go"
                                                  type="submit"></td>
        </tr>
        <tr>
          <td style="padding-left: 4px; padding-bottom: 2px; padding-top: 1px;"><a
          href="#" style="font-size: 10px; text-decoration: none" class="dec-inv">Advanced Search</a></td>
        </tr>

        </tbody>
      </table>
    </form>
  </td>
</tr>



<tr class="nga-verticalNavLine">
  <td style="padding-top: 3px; padding-bottom: 3px;" class="nga-verticalNavLoginTitle">&nbsp;Find...</td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View/Download Notice to Mariners files or search the NTM Corrections database" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">Notice to Mariners</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View/Download Navigation Publications and updates or search Publication databases" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">Publications</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View/Download Daily Memorandum files or search the Broadcast Warnings database" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">Broadcast Warnings</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View/Download Worldwide Threats to Shipping Reports published by the ONI" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">ONI Reports</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <g:link class="nga-verticalNavLink" title="Search the Anti-Shipping Activity Message database for reports of piracy" controller="Asam_master" action="asam">ASAM Search</g:link>
    </td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View current HYDROARC Warnings or search the HYDROARC database" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">HYDROARC Reports</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Search the Mobile Offshore Drillings Units database for locations of deployed drill rigs" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">MODU Search</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Search the NGA Hydrographic Catalog of Charts and Publications" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">Product Catalog</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View/Download additional Miscellaneous Nautical Products" href="#" style="text-decoration: none" class="nga-verticalNavLink">Misc.
      Products</a></td>
</tr>





<tr>
  <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
</tr>





<tr class="nga-verticalNavLine">
  <td style="padding-top: 3px; padding-bottom: 3px;" class="nga-verticalNavLoginTitle">&nbsp;Act...</td>
</tr>

<tr>

  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Report new information for inclusion in our nautical products and databases" href="#" style="text-decoration: none"
       class="nga-verticalNavLink">Submit Report</a></td>
</tr>



<tr>

  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Enroll in the Notice to Mariners Subscription Service" href="#"  style="text-decoration: none" class="nga-verticalNavLink">Subscribe
      to NtM</a></td>
</tr>




<tr>



  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">

    <a title="Submit a survey to rate the Maritime Safety Information Website" href="${Survey}" style="text-decoration: none"
       class="nga-verticalNavLink">Take a Survey</a></td>
</tr>






<tr>
  <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
</tr>




<tr class="nga-verticalNavLine">
  <td style="padding-top: 3px; padding-bottom: 3px;" class="nga-verticalNavLoginTitle">&nbsp;View...</td>
</tr>

<tr>

  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Access/Download calculators for solutions to common navigational computations" class="nga-verticalNavLink"
       href="#" style="text-decoration: none">Nautical Calculators</a></td>
</tr>

<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="View a graphic depiction of NGA's Chart Subregion scheme" class="nga-verticalNavLink"
       href="http://msi.nga.mil/MSISiteContent/StaticFiles/Images/subr_1.jpe" style="text-decoration: none" target="_blank">Geographic Locator</a></td>
</tr>
<tr>
  <td
  style="border-bottom: 1px solid rgb(170, 170, 170); background-color: rgb(204, 204, 204); padding-bottom: 3px; padding-left: 7px;">
    <a title="Visit the public Website of NGA's Digital Nautical Chart product" class="nga-verticalNavLink" target="dnc"
       href="/DNC.portal" style="text-decoration: none">DNC Homepage</a></td>
</tr>




<tr>
  <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
</tr>

<tr>
  <td class="nga-verticalNavLine" style="width: 100%; height: 1px"></td>
</tr>
<tr>
  <td class="nga-disclaimerText" style="padding-top: 5px; padding-bottom: 5px;" align="center">This is a U.S.
    Government system.&nbsp;&nbsp;Before continuing, read this&nbsp; <a class="nga-disclaimerLink" href="${Disclaimer}" style="text-decoration: none">disclaimer</a>.
  </td>
</tr>
<tr>
  <td class="nga-verticalNavLine" style="width: 100%; height: 1px"></td>
</tr>

    <tr>
      <td class="nga-disclaimerText" style="padding-top: 5px; padding-bottom: 5px;" align="center">Problems?&nbsp;<a
      class="nga-disclaimerLink" href="mailto:webmaster_nss@nga.mil" style="text-decoration: none">Contact&nbsp;NGA</a>.</td>
    </tr>
        <tr>
          <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
        </tr>








                                                <tr class="nga-verticalNavLine">
                                                  <td><img src="${resource(dir: 'images', file: 'spacer.gif')}" border="0" alt="spacer" /></td>
                                                </tr>

                                                </tbody>
                                                </table>
</html>