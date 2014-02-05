package msigrails

import org.apache.commons.logging.LogFactory


class Asam_masterController {
	private static final log = LogFactory.getLog(this)

    def index() { }
	
	def asam(){
		def subregions = []
		(11..19).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(21..29).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(35..38).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(41..44).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(51..57).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(61..63).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(71..76).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(81..83).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		(91..97).each {region ->
			subregions.add(["Subregion ${region}", region])
		}
		[Subregions: subregions]
	}
	
	def asam_query(){
		def msi_query_type = params.MSI_queryType
		def msi_filter_type = params.MSI_generalFilterType
		def msi_filter_value = params.MSI_generalFilterValue.toString()
		def msi_filter_type1 = params.MSI_additionalFilterType1
		def msi_filter_type2 = params.MSI_additionalFilterType2
		def msi_filter_value1 = params.MSI_additionalFilterValue1
		def msi_filter_value2 = params.MSI_additionalFilterValue2
		def msi_sort_type = params.MSI_outputOptionType1
		def msi_output_option_type2 = params.MSI_outputOptionType2
		def msi_sort_value = params.MSI_outputOptionValue1
		def msi_output_option_value2 = params.MSI_outputOptionValue2
		def msi_map = params.MSI_MAP
		def searchparam = []
		def sort_ord
		
		log.error("msi_filter_type = " + msi_filter_type)
		log.error("msi_filter_value = " + msi_filter_value)
		log.error("msi_sort_value = " + msi_sort_value)
		println(msi_filter_value)
		if (msi_sort_value.equals('Date DESC')){sort_ord = "a.occur_date desc, a.TX_YYYY desc, a.TX_NUM desc"}
		if (msi_sort_value.equals('Date ASC')){sort_ord = 'a.occur_date ASC, a.tx_yyyy ASC, a.tx_num ASC'}
		if (msi_sort_value.equals('Number DESC')){sort_ord = 'a.tx_yyyy DESC, a.tx_num DESC'}
		if (msi_sort_value.equals('Number ASC')){sort_ord = 'a.tx_yyyy ASC, a.tx_num ASC'}
		if (msi_filter_type == 'All'){searchparam[0] = 'All Anti-Shipping Activity Messages'}
		if (msi_filter_type == 'Subregion'){searchparam[0] = 'ASAMs by Subregion'} 
		if (msi_filter_type == 'VictimName'){searchparam[0] = "Victim's Name"}
		searchparam[1] = msi_filter_value
		searchparam[2] = 'None'
		if (msi_sort_value.equals('Date DESC')){searchparam[3] = 'Descending Date of Occurrence'}
		if (msi_sort_value.equals('Date ASC')){searchparam[3] = 'Ascending Date of Occurrence'}
		if (msi_sort_value.equals('Number DESC')){searchparam[3] = 'Descending ASAM Ref. Number'}
		if (msi_sort_value.equals('Number ASC')){searchparam[3] = 'Ascending ASAM Ref. Number'}
		def asams
		
		if (msi_filter_type == 'Subregion'){
			def type = "subregion"
			if (msi_filter_type1 == 'SpecificDate'){
				def asamdate = new Date().parse('yyyyMMdd', msi_filter_value1)
				def datestr = asamdate.format('dd-MMM-yy')
				def clause = "from Asam_master as a where a.${type}='${msi_filter_value}' and a.occur_date='${datestr}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			} else if(msi_filter_type1 == 'DateRange'){
				def asamdate = msi_filter_value1.tokenize(':')
				def date1 = new Date().parse('yyyyMMdd', asamdate.get(0))
				def datestr1 = date1.format('dd-MMM-yy')
				def date2 = new Date().parse('yyyyMMdd', asamdate.get(1))
				def datestr2 = date2.format('dd-MMM-yy')
				def clause = "from Asam_master as a where a.${type}='${msi_filter_value}' and a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			} else {
				def clause = "from Asam_master as a where a.${type}='${msi_filter_value}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			}
		}
		[Asamresult: asams]
	}
}
