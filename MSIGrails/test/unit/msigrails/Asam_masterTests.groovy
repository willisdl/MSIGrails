package msigrails



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Asam_master)
class Asam_masterTests {

    void testAsam_master() {
       def asam = Asam_master.where {subregion == "11"}
	   println(asam)
	   assert asam.victim == "VANDERPOOL EXPRESS"
    }
}
