package msigrails

class AsamService {
	
	
	def getSubs(){
		def subregions = []
		(11..19).each {region ->
			subregions.add(region)
			//subregions.add(["Subregion ${region}", region])
		}
		(21..29).each {region ->
			subregions.add(region)
		}
		(35..38).each {region ->
			subregions.add(region)
		}
		(41..44).each {region ->
			subregions.add(region)
		}
		(51..57).each {region ->
			subregions.add(region)
		}
		(61..63).each {region ->
			subregions.add(region)
		}
		(71..76).each {region ->
			subregions.add(region)
		}
		(81..83).each {region ->
			subregions.add(region)
		}
		(91..97).each {region ->
			subregions.add(region)
		}
		return subregions
	}

    def asamQuery(String filter_type, String filter_value, String sort_value, String filter_type1, String filter_value1) {
		def sort_ord
		def sort_type
		def sort_direct
		
		if (sort_value.equals("Date DESC")){sort_ord = "a.occur_date desc, a.TX_YYYY desc, a.TX_NUM desc"}
		if (sort_value.equals("Date DESC") || sort_value.equals("Date ASC")){sort_type = "date"}
		if (sort_value.equals("Number DESC") || sort_value.equals("Number ASC")){sort_type = "number"}
		if (sort_value.contains("ASC")){sort_direct = "asc"}
		if (sort_value.contains("DESC")){sort_direct = "desc"}
		if (sort_value.equals("Date ASC")){sort_ord = "a.occur_date ASC, a.TX_YYYY ASC, a.TX_NUM ASC"}
		if (sort_value.equals("Number DESC")){sort_ord = "a.TX_YYYY DESC, a.TX_NUM DESC"}
		if (sort_value.equals("Number ASC")){sort_ord = "a.TX_YYYY ASC, a.TX_NUM ASC"}
		def asams
		
		switch (filter_type){
			case "Subregion":
				def type = "subregion"
				if (filter_type1.equals("SpecificDate")){
					def asamdate = new Date().parse("yyyyMMdd", filter_value1)
					def datestr = asamdate.format("dd-MMM-yy")
					def clause = "from Asam_master as a where a.${type}='${filter_value}' and a.occur_date='${datestr}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else if(filter_type1.equals("DateRange")){
					def asamdate = filter_value1.tokenize(":")
					def date1 = new Date().parse("yyyyMMdd", asamdate.get(0))
					def datestr1 = date1.format("dd-MMM-yy")
					def date2 = new Date().parse("yyyyMMdd", asamdate.get(1))
					def datestr2 = date2.format("dd-MMM-yy")
					def clause = "from Asam_master as a where a.${type}='${filter_value}' and a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else {
					def clause = "from Asam_master as a where a.${type}='${filter_value}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				}
				break
			
			case "All":
				if (filter_type1.equals("SpecificDate")){
					def asamdate = new Date().parse("yyyyMMdd", filter_value1)
					def datestr = asamdate.format("dd-MMM-yy")
					def clause = "from Asam_master as a where a.occur_date='${datestr}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else if(filter_type1.equals("DateRange")){
					def asamdate = filter_value1.tokenize(":")
					def date1 = new Date().parse("yyyyMMdd", asamdate.get(0))
					def datestr1 = date1.format("dd-MMM-yy")
					def date2 = new Date().parse("yyyyMMdd", asamdate.get(1))
					def datestr2 = date2.format("dd-MMM-yy")
					def clause = "from Asam_master as a where a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else {
					//def clause = "from Asam_master as a order by ${sort_ord}"
					asams = Asam_master.findAll(){
						and{
							if (sort_type.equals("date")){
								order("occur_date",sort_direct)
								order("TX_YYYY",sort_direct)
								order("TX_NUM",sort_direct)
							}
							if (sort_type.equals("number")){
								order("TX_YYYY",sort_direct)
								order("TX_NUM",sort_direct)
							}
						}
					}
				}
				break
				
			case "SpecificNumber":
				def ref = filter_value.split("_")
				def clause = "from Asam_master as a where a.TX_YYYY='${ref[0]}' and a.TX_NUM>='${ref[1]}'"
				asams = Asam_master.findAll(clause)
				break
				
			case "NumberRange":
				def ref = filter_value.tokenize(":")
				def ref1 = ref[0].split("_")
				def ref2 = ref[1].split("_")
				def clause = "from Asam_master as a where ((a.TX_YYYY='${ref1[0]}' and a.TX_NUM>='${ref1[1]}')"
				def midyears = ref2[0].toInteger() - ref1[0].toInteger()
				if (midyears > 0){
					for(int i = 1; i < midyears; i++){
						def year = (ref1[0].toInteger() + i).toString()
						clause = clause + " or (a.TX_YYYY='${year}')"
					}
				}
				clause = clause + " or (a.TX_YYYY='${ref2[0]}' and a.TX_NUM<='${ref2[1]}'))"
				
				if(filter_type1.equals("SpecificDate")){
					def asamdate = new Date().parse("yyyyMMdd", filter_value1)
					def datestr = asamdate.format("dd-MMM-yy")
					clause = clause + " and a.occur_date='${datestr}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else if(filter_type1.equals("DateRange")){
					def asamdate = filter_value1.tokenize(":")
					def date1 = new Date().parse("yyyyMMdd", asamdate.get(0))
					def datestr1 = date1.format("dd-MMM-yy")
					def date2 = new Date().parse("yyyyMMdd", asamdate.get(1))
					def datestr2 = date2.format("dd-MMM-yy")
					clause = clause + (" and (a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}') order by ${sort_ord}")
					asams = Asam_master.findAll(clause)
				} else{
					clause = clause + " order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				}
				break
				
			case "VictimName":
				def name = filter_value.toLowerCase()
				def clause = "from Asam_master as a where lower(a.victim)='${name}'"
				if(filter_type1.equals("SpecificDate")){
					def asamdate = new Date().parse("yyyyMMdd", filter_value1)
					def datestr = asamdate.format("dd-MMM-yy")
					clause = clause + " and a.occur_date='${datestr}' order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				} else if(filter_type1.equals("DateRange")){
					def asamdate = filter_value1.tokenize(":")
					def date1 = new Date().parse("yyyyMMdd", asamdate.get(0))
					def datestr1 = date1.format("dd-MMM-yy")
					def date2 = new Date().parse("yyyyMMdd", asamdate.get(1))
					def datestr2 = date2.format("dd-MMM-yy")
					clause = ("from Asam_master as a where lower(a.victim)='${name}' and (a.occur_date>='${datestr1}' and a.occur_date<='${datestr2}') order by ${sort_ord}")
					asams = Asam_master.findAll(clause)
				} else{
					clause = clause + " order by ${sort_ord}"
					asams = Asam_master.findAll(clause)
				}
				break
					
		}
		
		return asams

    }
	
	def getSearchParams(String filter_type, String filter_value, String sort_value, String filter_type1, String filter_value1){
		def searchparam = []
		
		if (filter_type.equals("All")){searchparam[0] = "All Anti-Shipping Activity Messages"}
		if (filter_type.equals("Subregion")){searchparam[0] = "ASAMs by Subregion"}
		if (filter_type.equals("VictimName")){searchparam[0] = "Victim's Name:  ${filter_value}"}
		if (filter_type.equals("NumberRange")){
			def refnums = filter_value.tokenize(":")
			searchparam[0] = ("ASAM Ref. Number Range :   from ${refnums[0]} to ${refnums[1]}").toString()
			}
		searchparam[1] = filter_value
		searchparam[2] = "None"
		if (sort_value.equals("Date DESC")){searchparam[3] = "Descending Date of Occurrence"}
		if (sort_value.equals("Date ASC")){searchparam[3] = "Ascending Date of Occurrence"}
		if (sort_value.equals("Number DESC")){searchparam[3] = "Descending ASAM Ref. Number"}
		if (sort_value.equals("Number ASC")){searchparam[3] = "Ascending ASAM Ref. Number"}
		if (filter_type.equals("SpecificNumber")){searchparam[0] = ("Single ASAM Ref. Number: ${filter_value}").toString()}
		return searchparam
	}
}
