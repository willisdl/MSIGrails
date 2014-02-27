package msigrails

class AsamService {
	
	
	def getSubs(){
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
		subregions
	}

    def asamQuery(String filter_type, String filter_value, String sort_value, String filter_type1, String filter_value1) {
		def sort_ord
		
		
		if (sort_value.equals('Date DESC')){sort_ord = "a.occur_date desc, a.TX_YYYY desc, a.TX_NUM desc"}
		if (sort_value.equals('Date ASC')){sort_ord = 'a.occur_date ASC, a.TX_YYYY ASC, a.TX_NUM ASC'}
		if (sort_value.equals('Number DESC')){sort_ord = 'a.TX_YYYY DESC, a.TX_NUM DESC'}
		if (sort_value.equals('Number ASC')){sort_ord = 'a.TX_YYYY ASC, a.TX_NUM ASC'}
		if (filter_type == 'All'){searchparam[0] = 'All Anti-Shipping Activity Messages'}
		if (filter_type == 'Subregion'){searchparam[0] = 'ASAMs by Subregion'}
		if (filter_type == 'VictimName'){searchparam[0] = "Victim's Name"}
		searchparam[1] = filter_value
		searchparam[2] = 'None'
		if (sort_value.equals('Date DESC')){searchparam[3] = 'Descending Date of Occurrence'}
		if (sort_value.equals('Date ASC')){searchparam[3] = 'Ascending Date of Occurrence'}
		if (sort_value.equals('Number DESC')){searchparam[3] = 'Descending ASAM Ref. Number'}
		if (sort_value.equals('Number ASC')){searchparam[3] = 'Ascending ASAM Ref. Number'}
		def asams
		
		if (filter_type == 'Subregion'){
			def type = "subregion"
			if (filter_type1 == 'SpecificDate'){
				def asamdate = new Date().parse('yyyyMMdd', filter_value1)
				def datestr = asamdate.format('dd-MMM-yy')
				def clause = "from Asam_master as a where a.${type}='${msi_filter_value}' and a.occur_date='${datestr}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			} else if(filter_type1 == 'DateRange'){
				def asamdate = filter_value1.tokenize(':')
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
		
		if (filter_type == 'All'){
			if (filter_type1 == 'SpecificDate'){
				def asamdate = new Date().parse('yyyyMMdd', filter_value1)
				def datestr = asamdate.format('dd-MMM-yy')
				def clause = "from Asam_master as a where a.occur_date='${datestr}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			} else if(filter_type1 == 'DateRange'){
				def asamdate = filter_value1.tokenize(':')
				def date1 = new Date().parse('yyyyMMdd', asamdate.get(0))
				def datestr1 = date1.format('dd-MMM-yy')
				def date2 = new Date().parse('yyyyMMdd', asamdate.get(1))
				def datestr2 = date2.format('dd-MMM-yy')
				def clause = "from Asam_master as a where a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}' order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			} else {
				def clause = "from Asam_master as a order by ${sort_ord}"
				asams = Asam_master.findAll(clause)
			}
		}
		
		asams

    }
	
	def getSearchParams(String filter_type, String filter_value, String sort_value, String filter_type1, String filter_value1){
		def searchparam = []
		
		if (filter_type == 'All'){searchparam[0] = 'All Anti-Shipping Activity Messages'}
		if (filter_type == 'Subregion'){searchparam[0] = 'ASAMs by Subregion'}
		if (filter_type == 'VictimName'){searchparam[0] = "Victim's Name"}
		searchparam[1] = filter_value
		searchparam[2] = 'None'
		if (sort_value.equals('Date DESC')){searchparam[3] = 'Descending Date of Occurrence'}
		if (sort_value.equals('Date ASC')){searchparam[3] = 'Ascending Date of Occurrence'}
		if (sort_value.equals('Number DESC')){searchparam[3] = 'Descending ASAM Ref. Number'}
		if (sort_value.equals('Number ASC')){searchparam[3] = 'Ascending ASAM Ref. Number'}
		
		
	}
}
