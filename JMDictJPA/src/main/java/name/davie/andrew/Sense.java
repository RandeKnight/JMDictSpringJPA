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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;

	@Column(name="ANT")
	private String ant;

	@Column(name="DIAL")
	private String dial;

	@Column(name="EXAMPLE")
	private String example;

	@Column(name="FIELD")
	private String field;

	@Column(name="GLOSS")
	private String gloss;

	@Column(name="MISC")
	private String misc;

	@Column(name="POS")
	private String pos;

	@Column(name="S_INF")
	private String sInf;

	@Column(name="STAGK")
	private String stagk;

	@Column(name="STAGR")
	private String stagr;

	@Column(name="XREF")
	private String xref;

	//bi-directional many-to-one association to Lsource
	@OneToMany(mappedBy="sense")
	private Set<Lsource> lsources;

	//bi-directional many-to-one association to Entry
	@ManyToOne
	@JoinColumn(name="ENTRY_ENT_SEQ")
	private Entry entry;

	public Sense() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

}