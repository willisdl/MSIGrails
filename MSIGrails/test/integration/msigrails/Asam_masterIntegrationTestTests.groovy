package msigrails

import static org.junit.Assert.*
import org.junit.*
import org.apache.commons.logging.LogFactory

class Asam_masterIntegrationTestTests {
	private static final log = LogFactory.getLog(this)
	def asams = new Asam_masterController()

    @Before
    void setUp() {
        
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

	/*
	@Test
	void testSubregions() {
		def subs = asams.asam().Subregions
		assert subs[0] == 11
		def sublength = subs.size()
		assert subs[sublength - 1] == 97
		
	}
	
    @Test
    void testSubregionDateDesc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 24
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "389"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1985"
		assert asamlist[asamsize].TX_NUM == "30"
		def search = asams.asam_query().Searchparam
		assert search[0].equals('ASAMs by Subregion')
    }
	
	
	
	@Test
	void testSubregionDateAsc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 24
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1985"
		assert asamlist[0].TX_NUM == "30"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "389"
	}
	
	@Test
	void testSubregionDateRangeDateDesc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 24
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "307"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "273"
	}
	
	@Test
	void testSubregionDateRangeDateAsc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 24
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "273"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "307"
	}
	
	@Test
	void testSubregionSpecificDate() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 24
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		asams.params.MSI_additionalFilterType1 = "SpecificDate"
		asams.params.MSI_additionalFilterValue1 = "20021016"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "297"
	}
	
	
	
	@Test
	void testAllDateDesc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "419"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2008"
		assert asamlist[asamsize].TX_NUM == "137"
	}
	
	
	@Test
	void testAllDateAsc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2008"
		assert asamlist[0].TX_NUM == "137"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "419"
	}
	
	@Test
	void testAllSpecificDate() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		asams.params.MSI_additionalFilterType1 = "SpecificDate"
		asams.params.MSI_additionalFilterValue1 = "20021016"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "297"
	}
	
	@Test
	void testAllDateRangeDateDesc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "343"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "251"
	}
	
	@Test
	void testAllDateRangeDateAsc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "251"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "343"
	}
	
	@Test
	void testSubregionNumberDesc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 21
		asams.params.MSI_outputOptionValue1 = "Number DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "345"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1995"
		assert asamlist[asamsize].TX_NUM == "85"
		def search = asams.asam_query().Searchparam
		assert search[0].equals('ASAMs by Subregion')
	}
	
	@Test
	void testSubregionNumberAsc() {
		asams.params.MSI_generalFilterType = "Subregion"
		asams.params.MSI_generalFilterValue = 21
		asams.params.MSI_outputOptionValue1 = "Number ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1995"
		assert asamlist[0].TX_NUM == "85"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "345"
		def search = asams.asam_query().Searchparam
		assert search[0].equals('ASAMs by Subregion')
	}
	
	@Test
	void testAllNumberDesc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Number DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2009"
		assert asamlist[0].TX_NUM == "421"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "1985"
		assert asamlist[asamsize].TX_NUM == "1"
		def search = asams.asam_query().Searchparam
		assert search[0].equals('All Anti-Shipping Activity Messages')
	}
	
	@Test
	void testAllNumberAsc() {
		asams.params.MSI_generalFilterType = "All"
		asams.params.MSI_outputOptionValue1 = "Number ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "1985"
		assert asamlist[0].TX_NUM == "1"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2009"
		assert asamlist[asamsize].TX_NUM == "421"
		def search = asams.asam_query().Searchparam
		assert search[0].equals('All Anti-Shipping Activity Messages')
	}
	*/
	@Test
	void testSpecificNumber() {
		asams.params.MSI_generalFilterType = "SpecificNumber"
		asams.params.MSI_generalFilterValue = "2008_336"
		asams.params.MSI_outputOptionValue1 = "Number DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].victim.equals("CHEMICAL TANKER")
		def search = asams.asam_query().Searchparam
		def testSearch = "Single ASAM Ref. Number: 2008_336"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDesc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Number DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2004"
		assert asamlist[0].TX_NUM == "12"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "245"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberAsc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Number ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "245"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2004"
		assert asamlist[asamsize].TX_NUM == "12"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateDesc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "245"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2004"
		assert asamlist[asamsize].TX_NUM == "12"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateAsc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "245"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2004"
		assert asamlist[asamsize].TX_NUM == "12"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDesc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Number DESC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2003"
		assert asamlist[0].TX_NUM == "1"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "246"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeAsc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Number ASC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "246"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2003"
		assert asamlist[asamsize].TX_NUM == "1"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDateDesc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Date DESC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "343"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "251"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
	@Test
	void testNumberDateRangeDateAsc() {
		asams.params.MSI_generalFilterType = "NumberRange"
		asams.params.MSI_generalFilterValue = "2002_245:2004_12"
		asams.params.MSI_outputOptionValue1 = "Date ASC"
		asams.params.MSI_additionalFilterType1 = "DateRange"
		asams.params.MSI_additionalFilterValue1 = "20020901:20021201"
		def asamlist = asams.asam_query().Asamresult
		assert asamlist.size() != 0
		assert asamlist[0].TX_YYYY == "2002"
		assert asamlist[0].TX_NUM == "251"
		def asamsize = asamlist.size() - 1
		assert asamlist[asamsize].TX_YYYY == "2002"
		assert asamlist[asamsize].TX_NUM == "343"
		def search = asams.asam_query().Searchparam
		def testSearch = "ASAM Ref. Number Range :   from 2002_245 to 2004_12"
		assert search[0].equals(testSearch)
	}
	
}
