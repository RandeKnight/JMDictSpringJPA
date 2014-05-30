package name.davie.andrew;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the ENTRY database table.
 * 
 */
@Entity
@Table(name="ENTRY")
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry implements Serializable {
	protected static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENT_SEQ")
	protected Long ent_seq;

	@Column(name="KE_INF")
	protected String ke_inf;

	@Column(name="KE_PRI")
	protected String ke_pri;

	@Column(name="KEB")
	protected String keb;

	@Column(name="RE_INF")
	protected String re_inf;

	@Column(name="RE_NOKANJI")
	protected String re_nokanji;

	@Column(name="RE_PRI")
	protected String re_pri;

	@Column(name="RE_RESTR")
	protected String re_restr;

	@Column(name="REB")
	protected String reb;

	//bi-directional many-to-one association to Audit
	@OneToMany(mappedBy="entry")
	protected Set<Audit> audits = new HashSet<Audit>();

	//bi-directional many-to-one association to Sense
	@OneToMany(mappedBy="entry")
	protected Set<Sense> senses = new HashSet<Sense>();

	//bi-directional many-to-one association to Unicode
	@OneToMany(mappedBy="entry")
	protected Set<Unicode> unicodes = new HashSet<Unicode>();

	public Entry() {
	}

	public Long getEntSeq() {
		return this.ent_seq;
	}

	public void setEntSeq(String entSeq) {
		this.ent_seq = Long.parseLong(entSeq);
	}

	public String getKeInf() {
		return this.ke_inf;
	}

	public void setKeInf(String keInf) {
		this.ke_inf = keInf;
	}

	public String getKePri() {
		return this.ke_pri;
	}

	public void setKePri(String kePri) {
		this.ke_pri = kePri;
	}

	public String getKeb() {
		return this.keb;
	}

	public void setKeb(String keb) {
		this.keb = keb;
	}

	public String getReInf() {
		return this.re_inf;
	}

	public void setReInf(String reInf) {
		this.re_inf = reInf;
	}

	public String getReNokanji() {
		return this.re_nokanji;
	}

	public void setReNokanji(String reNokanji) {
		this.re_nokanji = reNokanji;
	}

	public String getRePri() {
		return this.re_pri;
	}

	public void setRePri(String rePri) {
		this.re_pri = rePri;
	}

	public String getReRestr() {
		return this.re_restr;
	}

	public void setReRestr(String reRestr) {
		this.re_restr = reRestr;
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

	public Sense addSense(Sense sens) {
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