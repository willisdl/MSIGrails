<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'qresults.css')}"/>

<html>
<head>
  <title>Query Results</title>
  <META http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <table border="0" style="padding: 0; border-spacing: 0; width: 645px; margin: 0px auto">
      <tr>
        <td>
          <table border="0" style="padding: 0; border-spacing: 0; width: 645px">
            <tr>
              <td>
                <img src="${resource(dir: 'images', file: 'logo_nga_pub.gif')}" alt="NGA Small Logo" />
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
<!-- begin body -->
  <table class="nga-resultsMainTable" border="0" style="padding: 0; border-spacing: 0; width: 645px; margin: 0px auto">
    <tr>
      <td>
        <!-- title table -->
        <table border="0" style="padding: 0; border-spacing: 0; width: 100%">
          <tr>
            <td class="nga-resultsTitle">
              Anti Shipping Activity
              <br>
              Messages
              <br>
              Query Results
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td>
        <!-- param table -->
        <table class="nga-resultsParamTable" border="0" style="padding: 0; border-spacing: 0; width: 645px">
          <tr>
            <td class="nga-resultsParam">
              <table border="0" style="padding: 0; border-spacing: 0; width: 645px">
                <tr>
                  <td style="color: #666666; padding-bottom: 2px; text-align: left; vertical-align: top">
                    <span class="nga-resultsParamBold">
                      Type of Search:
                    </span>
                    <span class="nga-resultsParamBoldColor">
                      ${Searchparam[0] }: ${Searchparam[1] }
                    </span>
                  </td>
                </tr>
                <tr>
                  <td style="color: #666666; padding-bottom: 2px; text-align: left; vertical-align: top">
                    <span class="nga-resultsParamBold">
                      Date Search:
                    </span>
                    <span class="nga-resultsParamBoldColor">
                      ${Searchparam[2] }
                    </span>
                  </td>
                </tr>
                <tr>
                  <td style="color: #666666; padding-bottom: 2px; text-align: left; vertical-align: top">
                    <span class="nga-resultsParamBold">
                      Sort Order:
                    </span>
                    <span class="nga-resultsParamBoldColor">
                      ${Searchparam[3] }
                    </span>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="nga-resultsSpacer">
              <img src="${resource(dir: 'images', file: spacer.gif')}" border="0" alt="space" width="1" />
            </td>
          </tr>
        </table>
      </td>
    </tr>

    <tr>
      <td>
        
        <table style="padding: 0; border-spacing: 0; width: 645px">
          <g:if Asamresult.length == 0>
              <tr>
                <td align="center" valign="top" class="nga-resultsNone">
                  The query returned no results.
                </td>
              </tr>
          </g:if>
          <g:else>
              <g:each var="asam" in="${Asamresult }">
                  <tr>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Date of Occurrence:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top; white-space: nowrap">
                      <g:formatDate format="MM/dd/yy" date="${asam.occur_date }"/>
                    </td>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Reference Number:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top; white-space: nowrap">
                      ${asam.TX_YYYY }-${asam.TX_NUM }
                    </td>
                  </tr>
                  <tr>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Geographical Subregion:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top; white-space: nowrap">
                      ${asam.subregion }
                    </td>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Geographical Location:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top; white-space: nowrap">
                      <% lat = asam.str_lat %>
                      <% lon = asam.str_lon %>
                      ${asam.str_lat[0] }&deg; ${asam.str_lat[1] }&quot; ${asam.str_lat[2] }&apos; ${asam.str_lat[3] }<br>${asm.str_lon[0] }&deg; ${asm.str_lon[1] }&quot; ${asm.str_lon[2] }&apos; ${asm.str_lon[3] }
                    </td>
                  </tr>
                  <tr>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Aggressor:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top">
                      ${asam.aggressor }
                    </td>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Victim:
                    </td>
                    <td class="nga-resultsCourier" style="text-align: left; vertical-align: top">
                      ${asam.victim }
                    </td>
                  </tr>
                  <tr>
                    <td class="nga-resultsData" style="text-align: left; vertical-align: top; white-space: nowrap">
                      Description:
                    </td>
                    <td colspan="3" class="nga-resultsCourier" style="text-align: left; vertical-align: top">
                      ${asam.text }
                    </td>
                  </tr>
                  <tr>
                    <td colspan="4" height="1" class="nga-footerLineLight"></td>
                  </tr>
              </g:each>
          </g:else>
        </table>
      </td>
    </tr>

    <tr>
      <td colspan="2" class="nga-resultsSpacer">
        <img src="/assets/spacer.gif" border="0" alt="space" width="1" />
      </td>
    </tr>
  </table>

  <table border="0" style="width: 645px; margin: 0px auto; padding: 0; border-spacing: 0">
    <tr>
      <td colspan="2">
        <img src="/assets/spacer.gif" border="0" alt="spacer" height="15" />
      </td>
    </tr>
    <tr>
      <td colspan="2" style="height: 1px" class="nga-footerLine"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center" class="nga-resultsData">
        Please direct any questions or comments pertaining to the site to <a href="mailto:webmaster_nss@nga.mil">webmaster_nss@nga.mil</a>
      </td>
    </tr>
    <tr>
      <td colspan="2" style="height: 1" class="nga-footerLine"></td>
    </tr>
    <tr>
      <td colspan="2">
        <img src="/assets/spacer.gif" border="0" alt="spacer" height="12" />
      </td>
    </tr>
    <tr>
      <td colspan="2" style="background-color: #000000; white-space: nowrap">
        <img src="/assets/nga_footer.gif" border="0" height="15" width="645" alt="NGA Footer"/>
        <img src="/assets/spacer.gif" border="0" alt="spacer">
      </td>
    </tr>
    <tr style="padding-bottom: 5px">
      <td style="padding-left: 15px; white-space: nowrap">
        <a href="javascript:window.print()" title="Print this page" class="nga-footerLink">
          <img src="/assets/footer_icon_print.gif" alt="Print this page" width="14" height="9" border="0"/>Print page
        </a>
      </td>
      <td>
        <img src="/assets/spacer.gif" border="0" alt="spacer" width="1"/>
      </td>
    </tr>
    <tr>
      <td colspan="2" style="height: 1" class="nga-footerLineLight"></td>
    </tr>
  </table>
</body>


</html>