package name.davie.andrew;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the LSOURCE database table.
 * 
 */
//@Entity
@Embeddable
@Table(name="LSOURCE")
@NamedQuery(name="Lsource.findAll", query="SELECT l FROM Lsource l")
public class Lsource implements Serializable {
	private static final long serialVersionUID = 1L;
/*
	@Id
	@Column(name="ID")
	private long id;

	@Id
	@Column(name="ENT_SEQ")
	protected long ent_seq;
*/	
	@Column(name="LANG")
	private String lang;

	@Column(name="LS_TYPE")
	private String lsType;

	@Column(name="LS_WASEI")
	private String lsWasei;

	@Column(name="VALUE")
	private String value;
/*
	//bi-directional many-to-one association to Sense
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="SENSE_ID", referencedColumnName="ID"),
		@JoinColumn(name="ENTRY_ENT_SEQ", referencedColumnName="ENT_SEQ")
	})
		private Sense sense;

	public Lsource() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
		public Sense getSense() {
		return this.sense;
	}

	public void setSense(Sense sense) {
		this.sense = sense;
	}

	public long getEnt_seq() {
		return ent_seq;
	}

	public void setEnt_seq(long ent_seq) {
		this.ent_seq = ent_seq;
	}
*/
	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLsType() {
		return this.lsType;
	}

	public void setLsType(String lsType) {
		this.lsType = lsType;
	}

	public String getLsWasei() {
		return this.lsWasei;
	}

	public void setLsWasei(String lsWasei) {
		this.lsWasei = lsWasei;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}



}