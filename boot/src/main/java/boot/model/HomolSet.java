package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="homolsets")
public class HomolSet implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=128)
	private String symbol;
	@Column(name="dbxref_id")
	private int dbxrefId;
	@Column(name="target_gene_product_id")
	private int targetGeneProductId;
	@Column(name="taxon_id")
	private int taxonId;
	@Column(name="type_id")
	private int typeId;
	@Column
	private String description;
	
	
	public HomolSet(String symbol, int dbxrefId, int targetGeneProductId,
			int taxonId, int typeId, String description) {
		super();
		this.symbol = symbol;
		this.dbxrefId = dbxrefId;
		this.targetGeneProductId = targetGeneProductId;
		this.taxonId = taxonId;
		this.typeId = typeId;
		this.description = description;
	}
	
	public HomolSet(){
		this("",0,0,0,0,"");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getDbxrefId() {
		return dbxrefId;
	}

	public void setDbxrefId(int dbxrefId) {
		this.dbxrefId = dbxrefId;
	}

	public int getTargetGeneProductId() {
		return targetGeneProductId;
	}

	public void setTargetGeneProductId(int targetGeneProductId) {
		this.targetGeneProductId = targetGeneProductId;
	}

	public int getTaxonId() {
		return taxonId;
	}

	public void setTaxonId(int taxonId) {
		this.taxonId = taxonId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "HomolSet [id=" + id + ", symbol=" + symbol + ", dbxrefId="
				+ dbxrefId + ", targetGeneProductId=" + targetGeneProductId
				+ ", taxonId=" + taxonId + ", typeId=" + typeId
				+ ", description=" + description + "]";
	}
	
	
	
}
