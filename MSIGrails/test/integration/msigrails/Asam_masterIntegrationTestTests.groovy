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

    @Test
    void testSubregion() {
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
    }
	
	@Test
	void testSubregionDateRange() {
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
		assert asamlist[asamsize].TX_YYYY == "2002"
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
}
