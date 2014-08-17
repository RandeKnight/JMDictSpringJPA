package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the SENSE database table.
 * 
 */
@Entity
@Table(name="SENSE")
@NamedQuery(name="Sense.findAll", query="SELECT s FROM Sense s")
public class Sense implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	protected int id;
	
	@Id
	@Column(name="ENT_SEQ")
	protected long ent_seq;

	@Column(name="ANT")
	protected String ant;

	@Column(name="DIAL")
	protected String dial;

	@Column(name="EXAMPLE")
	protected String example;

	@Column(name="FIELD")
	protected String field;

	@Column(name="GLOSS")
	protected String gloss;

	@Column(name="MISC")
	protected String misc;

	@Column(name="POS")
	protected String pos;

	@Column(name="S_INF")
	protected String sInf;

	@Column(name="STAGK")
	protected String stagk;

	@Column(name="STAGR")
	protected String stagr;

	@Column(name="XREF")
	protected String xref;

	//bi-directional many-to-one association to Lsource
	//@OneToMany(mappedBy="sense")
	@ElementCollection
	protected Set<Lsource> lsources;

	//bi-directional many-to-one association to Entry
	@ManyToOne
	@JoinColumn(name="ENTRY_ENT_SEQ")
	protected Entry entry;

	public Sense() {
	}
/*
	public Lsource addLsource(Lsource lsource) {
		getLsources().add(lsource);
		lsource.setSense(this);

		return lsource;
	}

	public Lsource removeLsource(Lsource lsource) {
		getLsources().remove(lsource);
		lsource.setSense(null);

		return lsource;
	}
*/
	
	public int getId() {
		return this.id;
	}


	public String getAnt() {
		return this.ant;
	}

	public void setAnt(String ant) {
		this.ant = ant;
	}

	public String getDial() {
		return this.dial;
	}

	public void setDial(String dial) {
		this.dial = dial;
	}

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getGloss() {
		return this.gloss;
	}

	public void setGloss(String gloss) {
		this.gloss = gloss;
	}

	public String getMisc() {
		return this.misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public String getPos() {
		return this.pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getSInf() {
		return this.sInf;
	}

	public void setSInf(String sInf) {
		this.sInf = sInf;
	}

	public String getStagk() {
		return this.stagk;
	}

	public void setStagk(String stagk) {
		this.stagk = stagk;
	}

	public String getStagr() {
		return this.stagr;
	}

	public void setStagr(String stagr) {
		this.stagr = stagr;
	}

	public String getXref() {
		return this.xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public Set<Lsource> getLsources() {
		return this.lsources;
	}

	public void setLsources(Set<Lsource> lsources) {
		this.lsources = lsources;
	}



	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public long getEnt_seq() {
		return ent_seq;
	}

	public void setEnt_seq(long ent_seq) {
		this.ent_seq = ent_seq;
	}

	public String getsInf() {
		return sInf;
	}

	public void setsInf(String sInf) {
		this.sInf = sInf;
	}

	public void setId(int id) {
		this.id = id;
	}

}