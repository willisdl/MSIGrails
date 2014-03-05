package msigrails

import org.apache.commons.logging.LogFactory


class Asam_masterController {
	private static final log = LogFactory.getLog(this)
	def asamService
	
	def asam(){
		def subregions = []
		subregions = asamService.getSubs()
		[Subregions: subregions]
	}
	
	def asam_query(){
		//def msi_query_type = params.MSI_queryType
		def msi_filter_type = params.MSI_generalFilterType
		def msi_filter_value = params.MSI_generalFilterValue.toString()
		def msi_filter_type1 = params.MSI_additionalFilterType1
		//def msi_filter_type2 = params.MSI_additionalFilterType2
		def msi_filter_value1 = params.MSI_additionalFilterValue1
		//def msi_filter_value2 = params.MSI_additionalFilterValue2
		//def msi_sort_type = params.MSI_outputOptionType1
		//def msi_output_option_type2 = params.MSI_outputOptionType2
		def msi_sort_value = params.MSI_outputOptionValue1
		//def msi_output_option_value2 = params.MSI_outputOptionValue2
		def msi_map = params.MSI_MAP
		
		def asams
		def searchparam = []
		
		asams = asamService.asamQuery(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		searchparam = asamService.getSearchParams(msi_filter_type, msi_filter_value, msi_sort_value, msi_filter_type1, msi_filter_value1)
		
		[Asamresult: asams, Searchparam: searchparam]
	}
}
