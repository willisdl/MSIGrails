package msigrails

class Asam_master implements Serializable{
	
	String TX_YYYY
	String TX_NUM
	String subregion
	float latitude
	float longitude
	String occur_date
	String aggressor
	String victim
	String text
	
	static mapping = {
		table 'nss.ASAM_MASTER'
		version false
		id composite: ["TX_YYYY","TX_NUM"]
		subregion column: 'SUBREGION'
		latitude column: 'LATITUDE'
		longitude column: 'LONGITUDE'
		occur_date column: 'OCCUR_DATE'
		aggressor column: 'AGGRESSOR'
		victim column: 'VICTIM'
		text column: 'TEXT'
	}

    static constraints = {
    }
}
