package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ENTRY database table.
 * 
 */
@Entity
@Table(name="ENTRY")
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENT_SEQ")
	private String entSeq;

	@Column(name="KE_INF")
	private String keInf;

	@Column(name="KE_PRI")
	private String kePri;

	@Column(name="KEB")
	private String keb;

	@Column(name="RE_INF")
	private String reInf;

	@Column(name="RE_NOKANJI")
	private String reNokanji;

	@Column(name="RE_PRI")
	private String rePri;

	@Column(name="RE_RESTR")
	private String reRestr;

	@Column(name="REB")
	private String reb;

	//bi-directional many-to-one association to Audit
	@OneToMany(mappedBy="entry")
	private Set<Audit> audits;

	//bi-directional many-to-one association to Sense
	@OneToMany(mappedBy="entry")
	private Set<Sense> senses;

	//bi-directional many-to-one association to Unicode
	@OneToMany(mappedBy="entry")
	private Set<Unicode> unicodes;

	public Entry() {
	}

	public String getEntSeq() {
		return this.entSeq;
	}

	public void setEntSeq(String entSeq) {
		this.entSeq = entSeq;
	}

	public String getKeInf() {
		return this.keInf;
	}

	public void setKeInf(String keInf) {
		this.keInf = keInf;
	}

	public String getKePri() {
		return this.kePri;
	}

	public void setKePri(String kePri) {
		this.kePri = kePri;
	}

	public String getKeb() {
		return this.keb;
	}

	public void setKeb(String keb) {
		this.keb = keb;
	}

	public String getReInf() {
		return this.reInf;
	}

	public void setReInf(String reInf) {
		this.reInf = reInf;
	}

	public String getReNokanji() {
		return this.reNokanji;
	}

	public void setReNokanji(String reNokanji) {
		this.reNokanji = reNokanji;
	}

	public String getRePri() {
		return this.rePri;
	}

	public void setRePri(String rePri) {
		this.rePri = rePri;
	}

	public String getReRestr() {
		return this.reRestr;
	}

	public void setReRestr(String reRestr) {
		this.reRestr = reRestr;
	}

	public String getReb() {
		return this.reb;
	}

	public void setReb(String reb) {
		this.reb = reb;
	}

	public Set<Audit> getAudits() {
		return this.audits;
	}

	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}

	public Audit addAudit(Audit audit) {
		getAudits().add(audit);
		audit.setEntry(this);

		return audit;
	}

	public Audit removeAudit(Audit audit) {
		getAudits().remove(audit);
		audit.setEntry(null);

		return audit;
	}

	public Set<Sense> getSenses() {
		return this.senses;
	}

	public void setSenses(Set<Sense> senses) {
		this.senses = senses;
	}

	public Sense addSens(Sense sens) {
		getSenses().add(sens);
		sens.setEntry(this);

		return sens;
	}

	public Sense removeSens(Sense sens) {
		getSenses().remove(sens);
		sens.setEntry(null);

		return sens;
	}

	public Set<Unicode> getUnicodes() {
		return this.unicodes;
	}

	public void setUnicodes(Set<Unicode> unicodes) {
		this.unicodes = unicodes;
	}

	public Unicode addUnicode(Unicode unicode) {
		getUnicodes().add(unicode);
		unicode.setEntry(this);

		return unicode;
	}

	public Unicode removeUnicode(Unicode unicode) {
		getUnicodes().remove(unicode);
		unicode.setEntry(null);

		return unicode;
	}

}