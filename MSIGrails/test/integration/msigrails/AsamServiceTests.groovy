package msigrails

import static org.junit.Assert.*
import org.junit.*
import org.apache.commons.logging.LogFactory

class AsamServiceTests {
	private static final log = LogFactory.getLog(this)
	def asamService

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

	
    @Test
	void testSubregions() {
		def subs = asamService.getSubs()
		assert subs[0] == 11
		def sublength = subs.size()
		assert subs[sublength - 1] == 97
		
	}
	//asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
	@Test
	void testSubregionDateDesc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "24"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "389"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1985"
		assert asamlist[asamsize].TX_NUM == "30"
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
	}
	
	@Test
	void testSubregionDateAsc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "24"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1985"
		assert asamlist[0].TX_NUM == "30"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "389"
	}
	
	@Test
	void testSubregionDateRangeDateDesc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "24"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "307"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "273"
	}
	
	@Test
	void testSubregionDateRangeDateAsc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "24"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "273"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "307"
	}
	
	@Test
	void testSubregionSpecificDate() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "24"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "SpecificDate"
		def msi_filter_value1 = "20021016"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "297"
	}
	
	
	
	@Test
	void testAllDateDesc() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "419"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2008"
		assert asamlist[asamsize].TX_NUM == "137"
	}
	
	@Test
	void testAllDateAsc() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2008"
		assert asamlist[0].TX_NUM == "137"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "419"
	}
	
	@Test
	void testAllSpecificDate() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "SpecificDate"
		def msi_filter_value1 = "20021016"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "297"
	}
	
	@Test
	void testAllDateRangeDateDesc() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "343"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "251"
	}
	
	@Test
	void testAllDateRangeDateAsc() {def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "251"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "343"
	}
	
	@Test
	void testSubregionNumberDesc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "21"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "345"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1995"
		assert asamlist[asamsize].TX_NUM == "85"
	}
	
	@Test
	void testSubregionNumberAsc() {
		def msi_filter_type = "Subregion"
		def msi_filter_value = "21"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals('ASAMs by Subregion')
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1995"
		assert asamlist[0].TX_NUM == "85"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "345"
	}
	
	@Test
	void testAllNumberDesc() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "421"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1985"
		assert asamlist[asamsize].TX_NUM == "1"
	}
	
	@Test
	void testAllNumberAsc() {
		def msi_filter_type = "All"
		def msi_filter_value = "-999"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert search[0].equals("All Anti-Shipping Activity Messages")
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1985"
		assert asamlist[0].TX_NUM == "1"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "421"
	}
	
	@Test
	void testSpecificNumber() {
		def msi_filter_type = "SpecificNumber"
		def msi_filter_value = "2008_336"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].victim.equals("CHEMICAL TANKER")
		def testSearch = "Single ASAM Ref. Number: 2008_336"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDesc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2004"
		assert asamlist[0].TX_NUM == "12"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "245"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberAsc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "245"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2004"
		assert asamlist[asamsize].TX_NUM == "12"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateDesc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2004"
		assert asamlist[0].TX_NUM == "12"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "245"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateAsc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "245"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2004"
		assert asamlist[asamsize].TX_NUM == "12"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDesc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2003"
		assert asamlist[0].TX_NUM == "1"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "246"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeAsc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "246"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2003"
		assert asamlist[asamsize].TX_NUM == "1"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDateDesc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "343"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "251"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDateAsc() {
		def msi_filter_type = "NumberRange"
		def msi_filter_value = "2002_245:2004_12"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20020901:20021201"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "251"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "343"
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testVictimDateDesc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "297"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1996"
		assert asamlist[asamsize].TX_NUM == "9"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimDateAsc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1996"
		assert asamlist[0].TX_NUM == "9"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "297"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimNumberDesc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "297"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1996"
		assert asamlist[asamsize].TX_NUM == "9"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimNumberAsc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "-999"
		def msi_filter_value1 = "-999"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1996"
		assert asamlist[0].TX_NUM == "9"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "297"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimDateRangeDateDesc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20010101:20011231"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2001"
		assert asamlist[0].TX_NUM == "351"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2001"
		assert asamlist[asamsize].TX_NUM == "119"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimDateRangeDateAsc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Date_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20010101:20011231"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2001"
		assert asamlist[0].TX_NUM == "119"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2001"
		assert asamlist[asamsize].TX_NUM == "351"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimDateRangeNumberDesc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Number_DESC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20010101:20011231"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2001"
		assert asamlist[0].TX_NUM == "351"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2001"
		assert asamlist[asamsize].TX_NUM == "119"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimDateRangeNumberAsc() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Number_ASC"
		def msi_filter_type1 = "DateRange"
		def msi_filter_value1 = "20010101:20011231"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2001"
		assert asamlist[0].TX_NUM == "119"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2001"
		assert asamlist[asamsize].TX_NUM == "351"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
	@Test
	void testVictimSpecificDate() {
		def msi_filter_type = "VictimName"
		def msi_filter_value = "yacht"
		def msi_sort_value = "Date_DESC"
		def msi_filter_type1 = "SpecificDate"
		def msi_filter_value1 = "20010812"
		def asamlist = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		def search = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2001"
		assert asamlist[0].TX_NUM == "244"
		def testSearch = "Victim's Name:  yacht"
		assert search[0] == (testSearch)
	}
	
}
