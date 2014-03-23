<%@page import="java.awt.event.ItemEvent"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'nga_stylesheet.css')}"/>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'msi_stylesheet.css')}"/>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'formcatalog.css')}"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII"/>
<meta name="layout" content="main"/>
<title>Maritime Safety Information</title>

<script>
    function getInternetExplorerVersion(){
        // Returns the version of Windows Internet Explorer or a -1
        // (indicating the use of another browser).
        var rv = -1; // Return value assumes failure.
        if (navigator.appName == 'Microsoft Internet Explorer'){
            var ua = navigator.userAgent;
            var re  = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null) rv = parseFloat( RegExp.$1 );
        }
        return rv;
    }

    function showhide() {
        var ieVer = getInternetExplorerVersion();
        //console.debug("IE Version = " + ieVer);
        var obj1 = document.getElementById("mapselect");
        if(ieVer >= 8.0 || ieVer == -1) {
          document.getElementById("mapselect").style.visibility = "visible";
          //console.debug("Map visible");
        } else {
          document.getElementById("mapselect").style.visibility = "hidden";
          //console.debug("Map hidden");
        }

    }

    function execute(formName) {
        if(buildAndVerifyProcessForm(formName)) {
          invokeResultsPopup();
          //popupWindow('', "MSI_MAP_Query_Results", 800, 600) ;
          document.processForm.submit();
        }
      }

      function swapDivFromSelect(formName, selectElementName) {
        var divID = getSelectListValue(formName, selectElementName);
        // Default setting...
        if(divID == "") {
          resetAllLayers();
          return;
        } else {
          var divObj = getDivObject(divID);
          if(divObj) {
            if(selectElementName.substr(0,1) == "_") {
              hideSubLayers(selectElementName);
            } else {
              resetAllLayers();
            }
            changeVisibility(divID, "visible");
          } else {
            alert("You must have a browser that handles DHTML to perform this operation.");
          }
        }
      }

      function hideSubLayers(selectElementName) {
        if(selectElementName == "_asamGenFilterSelect") {
          changeVisibility("asamGenFilterAll", "hidden");
          changeVisibility("asamGenFilterSpecificNumber", "hidden");
          changeVisibility("asamGenFilterNumberRange", "hidden");
          changeVisibility("asamGenFilterSubregion", "hidden");
          changeVisibility("asamGenFilterVictimName", "hidden");
        }
        if(selectElementName == "_asamAddFilter") {
          changeVisibility("asamAddNone", "hidden");
          changeVisibility("asamAddDate", "hidden");
          changeVisibility("asamAddDateRange", "hidden");
        }
      }

      function resetAllLayers() {
          // asam layers...
          changeVisibility("asamGenFilterAll", "hidden");
          changeVisibility("asamGenFilterSpecificNumber", "hidden");
          changeVisibility("asamGenFilterNumberRange", "hidden");
          changeVisibility("asamGenFilterSubregion", "hidden");
          changeVisibility("asamGenFilterVictimName", "hidden");
          resetSelectList("asamForm", "_asamGenFilterSelect");
          changeVisibility("asamAddNone", "hidden");
          changeVisibility("asamAddDate", "hidden");
          changeVisibility("asamAddDateRange", "hidden");
          resetSelectList("asamForm", "_asamAddFilter");
      }

      function buildAndVerifyProcessForm(formName) {

          // Build form for asam Warnings...
          if(formName == "asamForm") {
              var genFilterType = getSelectListValue(formName, "_asamGenFilterSelect");
              var addFilterType = getSelectListValue(formName, "_asamAddFilter");
              document.processForm.MSI_queryType.value = "ASAM";
              if(genFilterType == "asamGenFilterAll") {
                  document.processForm.MSI_generalFilterType.value = "All";
                  document.processForm.MSI_generalFilterValue.value = "-999";
              }
              if(genFilterType == "asamGenFilterSpecificNumber") {
                  yearValue = Number(document.asamForm.asamAddYear.value);
                  if(isNaN(yearValue)) { alert("You must enter a number value for Year search."); return false; }
                  if(yearValue < 1000) { alert("You must enter a 4-digit year for Year search."); return false; }

                  numValue = Number(document.asamForm.asamGenFilterSpecificNumber.value);
                  if(isNaN(numValue)) { alert("You must enter a number value for Reference Number search."); return false; }
                  if(numValue < 1) { alert("You must enter a valid ASAM ref number for Reference Number search."); return false; }

                  document.processForm.MSI_generalFilterType.value = "SpecificNumber";
                  document.processForm.MSI_generalFilterValue.value = yearValue+"_"+numValue;
              }
              if(genFilterType == "asamGenFilterNumberRange") {
                  year1Value = Number(document.asamForm.asamAddYearRangeFrom.value);
                  year2Value = Number(document.asamForm.asamAddYearRangeTo.value);
                  if(isNaN(year1Value) || isNaN(year2Value)) { alert("You must enter number values for Year Range search."); return false; }
                  if(year1Value < 1000 || year2Value < 1000) { alert("You must enter a 4-digit year for Year Range search."); return false; }
                  if(year1Value > year2Value) { alert("The starting year in the range cannot be greater than the ending year."); return false; }

                  num1Value = Number(document.asamForm.asamGenFilterNumberRangeFrom.value);
                  num2Value = Number(document.asamForm.asamGenFilterNumberRangeTo.value);
                  if(isNaN(num1Value) || isNaN(num2Value)) { alert("You must enter number values for Reference Number Range search."); return false; }
                  if(num1Value < 1 || num2Value < 1) { alert("You must enter a valid reference number for Reference Number Range search."); return false; }
                  if((num1Value > num2Value) && (year1value == year2value)) { alert("The starting number in the range cannot be greater than the ending number."); return false; }

                  document.processForm.MSI_generalFilterType.value = "NumberRange";
                  document.processForm.MSI_generalFilterValue.value = year1Value+"_"+num1Value+":"+year2Value+"_"+num2Value;
              }
              if(genFilterType == "asamGenFilterSubregion") {
                  document.processForm.MSI_generalFilterType.value = "Subregion";
                  document.processForm.MSI_generalFilterValue.value = getSelectListValue(formName, "asamGenSubregion");
              }
              if(genFilterType == "asamGenFilterVictimName") {
                  nameValue = document.asamForm.asamGenFilterVictimName.value;
                  if(nameValue == "") { alert("You must provide a name for Victim's Name search."); return false; }
                  document.processForm.MSI_generalFilterType.value = "VictimName";
                  document.processForm.MSI_generalFilterValue.value = nameValue;
              }
              if(addFilterType == "asamAddNone") {
                  document.processForm.MSI_additionalFilterType1.value = "None";
                  document.processForm.MSI_additionalFilterValue1.value = "-999";
              }
              if(addFilterType == "asamAddDate") {
                  document.processForm.MSI_additionalFilterType1.value = "SpecificDate";
                  year1Value = Number(document.asamForm.asamAddDateY.value);
                  month1Value = document.asamForm.asamAddDateM.value;
                  day1Value = document.asamForm.asamAddDateD.value;
                  if(isNaN(year1Value)) { alert("You must enter a number value for Year search."); return false; }
                  if( year1Value < 1000 ) { alert("You must enter a 4-digit year for Date search."); return false; }
                  document.processForm.MSI_additionalFilterValue1.value = day1Value+"/"+month1Value+"/"+year1Value;
              }
              if(addFilterType == "asamAddDateRange") {
                  year1Value  = Number(document.asamForm.asamAddDateRangeFromY.value);
                  month1Value = document.asamForm.asamAddDateRangeFromM.value;
                  day1Value   = document.asamForm.asamAddDateRangeFromD.value
                  year2Value  = Number(document.asamForm.asamAddDateRangeToY.value);
                  month2Value = document.asamForm.asamAddDateRangeToM.value;
                  day2Value   = document.asamForm.asamAddDateRangeToD.value
                  combined1 = year1Value+month1Value+day1Value;
                  combined2 = year2Value+month2Value+day2Value;
                  if(isNaN(year1Value) || isNaN(year2Value)) { alert("You must enter a number value for Year search."); return false; }
                  if(year1Value < 1000 || year2Value < 1000) { alert("You must enter a 4-digit year for Date Range search."); return false; }
                  if(combined1 > combined2) { alert("The starting Date in the range cannot be greater than the ending Date."); return false; }
                  document.processForm.MSI_additionalFilterType1.value = "DateRange";
                  document.processForm.MSI_additionalFilterValue1.value = year1Value+month1Value+day1Value+":"+year2Value+month2Value+day2Value;
              }
              document.processForm.MSI_outputOptionType1.value = "SortBy";
              document.processForm.MSI_outputOptionValue1.value = getSelectListValue(formName, "asamSortBy")+"_"+getSelectListValue(formName, "asamSortOrder");


              if (document.asamForm.asamShowOnMap.checked){
                  document.processForm.MSI_MAP.value = "true";

              }else{
                  document.processForm.MSI_MAP.value = "-999";
              }

              return true;

          }
          return false;
      }
</script>
</head>


<body>
  <div class="body">

<html:render file= "${grailsApplication.config.repo_path }MSISiteContent/Articles/Message Descriptions/AntiShippingActivityMessages.html"/>
<g:form name="processForm" controller="Asam_master" action="asam_query" method="post" target="MSI_Query_Results">
  <input type="hidden" name="MSI_queryType" id="MSI_queryType" value="-999">
  <input type="hidden" name="MSI_generalFilterType" id="MSI_generalFilterType" value="-999">
  <input type="hidden" name="MSI_generalFilterValue" id="MSI_generalFilterValue" value="-999">
  <input type="hidden" name="MSI_additionalFilterType1" id="MSI_additionalFilterType1" value="-999">
  <input type="hidden" name="MSI_additionalFilterType2" id="MSI_additionalFilterType2" value="-999">
  <input type="hidden" name="MSI_additionalFilterValue1" id="MSI_additionalFilterValue1" value="-999">
  <input type="hidden" name="MSI_additionalFilterValue2" id="MSI_additionalFilterValue2" value="-999">
  <input type="hidden" name="MSI_outputOptionType1" id="MSI_outputOptionType1" value="-999">
  <input type="hidden" name="MSI_outputOptionType2" id="MSI_outputOptionType2" value="-999">
  <input type="hidden" name="MSI_outputOptionValue1" id="MSI_outputOptionValue1" value="-999">
  <input type="hidden" name="MSI_outputOptionValue2" id="MSI_outputOptionValue2" value="-999">
  <input type="hidden" name="MSI_MAP" id="MSI_MAP" value="-999">

</g:form>

<form name="asamForm">
    <table border="0" style="width: 606px; padding: 0; border-spacing: 0; background-color:#EEEEEE;padding:5px;border:2px solid #CCCCCC">
      <tr>
        <td style="white-space: nowrap">Anti-Shipping Activity Messages (ASAM) Query:</td>
        <td style="white-space: nowrap; text-align: right; padding-right: 15px;">
          <a href="#">Query Directions</a>
        </td>
      </tr>
    </table>
    <table border="0" style="width: 606px; padding: 0; border-spacing: 0; height: 80px" class="nga-queryRow">
      <tr>
        <td colspan="3" style="height: 10px"></td>
      </tr>
      <tr>
        <td style="width: 200px; height: 75px; color:#666666; text-align: left; vertical-align: middle">
          <label for="_asamGenFilterSelect">Retrieve:</label><br>
          <select class="nga-formTextLight" size="1" name="_asamGenFilterSelect" id="_asamGenFilterSelect" onchange="swapDivFromSelect('asamForm', '_asamGenFilterSelect')">
            <option value="asamGenFilterAll" selected>All</option>
            <option value="asamGenFilterSpecificNumber">by Ref. Number</option>
            <option value="asamGenFilterNumberRange">by Ref. Number Range</option>
            <option value="asamGenFilterSubregion">by Subregion</option>
            <option value="asamGenFilterVictimName">by Victim's Name</option>
          </select>
        </td>
        <td style="text-align: center" class="nga-queryValueCell">&nbsp;
          <div id="asamGenFilterAll" style="position:absolute;right:144px;bottom:230px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td>&nbsp;</td></tr>
            </table>
          </div>

          <!--NEW CHANGES-->
          <div id="asamGenFilterSpecificNumber" style="position:absolute;right:650px;bottom:125px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center">
                <table border="0" style="padding: 0; border-spacing: 3" >
                  <tr>
                    <td class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (yyyy)
                    </td>&nbsp;
                    <td></td>
                    <td class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (nnnn)
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center; white-space: nowrap">

                      <input type="text" name="asamAddYear" id="asamAddYear" size="4" maxlength="4"></td>
                    <td> - </td>
                    <td style="white-space: nowrap"><input type="text" name="asamGenFilterSpecificNumber" id="asamGenFilterSpecificNumber" size="4" maxlength="4"></td>
                  </tr>
                </table>
              </td>
              </tr>
            </table>
          </div>

          <div id="asamGenFilterNumberRange" style="position:absolute;right:600px;bottom:105px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center">
                <table border="0" style="padding: 0; border-spacing: 3" >
                  <tr>
                    <td>&nbsp;</td>
                    <td class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (yyyy)
                    </td>
                    <td>&nbsp;</td>
                    <td  class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (nnnn)
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: left; white-space: nowrap"><label for="asamGenFilterNumberRangeFrom">From:</label></td>
                    <td style="text-align: center; white-space: nowrap"><input type="text" name="asamAddYearRangeFrom" id="asamAddYearRangeFrom" size="4" maxlength="4"></td>
                    <td>&nbsp;&nbsp; - &nbsp;&nbsp;</td>
                    <td style="text-align: center; white-space: nowrap"><input type="text" name="asamGenFilterNumberRangeFrom" id="asamGenFilterNumberRangeFrom" size="4" maxlength="4"></td>
                  </tr>
                  <tr>
                    <td style="text-align: left; white-space: nowrap"><label for="asamGenFilterNumberRangeTo">&nbsp;&nbsp;To:</label></td>
                    <td style="text-align: center; white-space: nowrap"><input type="text" name="asamAddYearRangeTo" id="asamAddYearRangeTo" size="4" maxlength="4"></td>
                    <td>&nbsp;&nbsp; - &nbsp;&nbsp;</td>
                    <td style="text-align: center; white-space: nowrap"><input type="text" name="asamGenFilterNumberRangeTo" id="asamGenFilterNumberRangeTo" size="4" maxlength="4"></td>
                  </tr>
                </table>
              </td></tr>
            </table>
          </div>
          <!--END NEW CHANGES-->


          <div id="asamGenFilterSubregion" style="align-content: center; vertical-align: middle; visibility:hidden">
            <table style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center; vertical-align: middle">
                <div style="position:relative; left: 150px; overflow: auto; height: 100%;">

                <select style="display: inline" class="nga-formTextLight" size="1" name="asamGenSubregion" id="asamGenSubregion">
                  <g:each in="${Subregions }" var="sub">
                  	<option value="${sub }">${sub }</option>
                  </g:each>
                </select>

                </div>
              </td></tr>
            </table>
          </div>
          <div id="asamGenFilterVictimName" style="position:absolute;right:83px;bottom:234px;visibility:hidden">
            <table style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center">
                <table border="0" style="padding: 0; border-spacing: 3" >
                  <tr>
                    <td style="white-space: nowrap"><input type="text" name="asamGenFilterVictimName" id="asamGenFilterVictimName" size="20" maxlength="100"></td>
                  </tr>
                </table>
              </td></tr>
            </table>
          </div>
        </td>
        <td style="width: 2px"></td>
      </tr>
      <tr><td colspan="3" style="height: 10px"></td></tr>
    </table>
    <table style="padding: 0; border-spacing: 0; width: 606px; height: 100px" class="nga-queryRow">
      <tr><td colspan="3" style="height: 10px"></td></tr>
      <tr>
        <td style="width: 200px; color:#666666; text-align: left; vertical-align: middle">
          <label for="_asamAddFilter">Date Filter:</label><br>
          <select class="nga-formTextLight" size="1" name="_asamAddFilter" id="_asamAddFilter" onchange="swapDivFromSelect('asamForm', '_asamAddFilter')">
            <option value="asamAddNone" selected>None</option>
            <option value="asamAddDate">Occurrence Date</option>
            <option value="asamAddDateRange">Occurrence Date Range</option>
          </select>
        </td>
        <td style="text-align: center" class="nga-queryValueCell">&nbsp;
          <div id="asamAddNone" style="position:absolute;bottom:142px;right:87px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td>&nbsp;</td></tr>
            </table>
          </div>
          <div id="asamAddDate" style="position:absolute;bottom:142px;right:87px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center">
                <table border="0" style="padding: 0; border-spacing: 5px" >
                  <tr>
                    <td class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (mm/dd/yyyy)
                    </td>
                  </tr>
                  <tr>
                    <td style="white-space: nowrap">
                      <select name="asamAddDateM" id="asamAddDateM">
	                      <g:each var="m" in="${1..12 }">
	                      	<option value="${m }">${m }</option>
	                      </g:each>
                      </select> /
                      <select name="asamAddDateD">
	                      <g:each var="d" in="${1..31 }">
	                      	<option value="${d }">${d }</option>
	                      </g:each>
                      </select> /
                      <input type="text" name="asamAddDateY" id="asamAddDateY" size="4" maxlength="4" />
                    </td>
                  </tr>
                </table>
              </td></tr>
            </table>
          </div>
          <div id="asamAddDateRange" style="position:absolute;bottom:128px;right:78px;visibility:hidden">
            <table border="0" style="padding: 0; border-spacing: 0">
              <tr><td style="text-align: center">
                <table border="0" style="padding: 0; border-spacing: 5" >
                  <tr>
                    <td>&nbsp;</td>
                    <td class="nga-queryLabelNote" style="text-align: center; white-space: nowrap">
                      (mm/dd/yyyy)
                    </td>
                  </tr>
                  <tr>
                    <td style="white-space: nowrap"><label for="asamAddDateRangeFromM">From:</label></td>
                    <td style="white-space: nowrap">
                      <select name="asamAddDateRangeFromM" id="asamAddDateRangeFromM">
                        <g:each var="m1" in="${1..12 }">
	                      	<option value="${m1 }">${m1 }</option>
	                    </g:each>
                      </select> /
                      <select name="asamAddDateRangeFromD">
                        <g:each var="d1" in="${1..31 }">
	                      	<option value="${d1 }">${d1 }</option>
	                    </g:each>
                      </select> /
                      <input type="text" name="asamAddDateRangeFromY" id="asamAddDateRangeFromY" size="4" maxlength="4" />
                    </td>
                  </tr>
                  <tr>
                    <td style="white-space: nowrap"><label for="asamAddDateRangeToM">To:</label></td>
                    <td style="white-space: nowrap">
                      <select name="asamAddDateRangeToM" id="asamAddDateRangeToM">
                        <g:each var="m2" in="${1..12 }">
	                      	<option value="${m2 }">${m2 }</option>
	                    </g:each>
                      </select> /
                      <select name="asamAddDateRangeToD">
                        <g:each var="d2" in="${1..31 }">
	                      	<option value="${d2 }">${d2 }</option>
	                    </g:each>
                      </select> /
                      <input type="text" name="asamAddDateRangeToY" id="asamAddDateRangeToY" size="4" maxlength="4" />
                    </td>
                  </tr>
                </table>
              </td></tr>
            </table>
          </div>
        </td>
        <td style="width: 2px"></td>
      </tr>
      <tr><td colspan="3" style="height: 10px"></td></tr>
    </table>
    <table border="0" style="padding: 0; border-spacing: 0; width: 606px; height: 85px" class="nga-queryRow">
      <tr><td colspan="3" style="height: 10px"></td></tr>
      <tr>
        <td style="padding-bottom:2px; width: 200px; text-align: left; vertical-align: middle; white-space: nowrap">
          <span style="color:#666666">Output Options:</span><br>
          <label for="asamSortBy"><span style="">Sort by:</span></label>
          <select name="asamSortBy" id="asamSortBy">
            <option value="Date">Occurrence Date</option>
            <option value="Number">Ref. Number</option>
          </select>
        </td>
        <td style="text-align: center; vertical-align: middle; white-space: nowrap" class="nga-queryValueCell">
          <br>
          <label for="asamSortOrder">Sort Order:</label> &nbsp;&nbsp;
          <select name="asamSortOrder" id="asamSortOrder">
            <option value="ASC">Ascending</option>
            <option value="DESC" selected>Descending</option>
          </select>
        </td>
        <td style="width: 2px"></td>
      </tr>
      <tr><td colspan="3" style="height: 10px"></td></tr>
      <tr><td id="mapselect" colspan="3" style="height: 10px">Show results on Map:<input type="checkbox" name="asamShowOnMap" id="asamShowOnMap"></td></tr>
      <script>
        showhide();
      </script>
    </table>
    <table border="0" style="padding: 0; border-spacing: 0; width: 606px" class="nga-querySubmitRow">
      <tr>
        <td style="text-align: right"><input class="nga-pageContentButton" type="submit" value="Search" onclick="execute('asamForm');return false;">&nbsp;&nbsp;</td>
      </tr>
    </table>
</form>

  </div>
  

</body>
</html>