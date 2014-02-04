
package msigrails

import grails.test.mixin.*

import org.junit.*

import sun.awt.SubRegionShowable;

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(Asam_masterController)
class Asam_masterControllerTests {

	void testAsamquery(){
		params.MSI_generalFilterType = "Subregion"
		params.MSI_generalFilterValue = "11"
		params.MSI_outputOptionValue1 = "Date DESC"
		def asams = controller()
		def asamlist = asams.asam_query()
		assert asamlist.size() != 0
		//assert asamlist.victim == "VANDERPOOL EXPRESS"
	}
}
