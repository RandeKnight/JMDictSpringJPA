package name.davie.andrew;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the UNICODE database table.
 * 
 */
@Embeddable
public class UnicodePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="UNICODE")
	private String unicode;

	@Column(name="ENT_SEQ")
	private String ent_seq;

	public UnicodePK() {
	}
	public UnicodePK(String unicode, String ent_seq) {
		this.unicode=unicode;
		this.ent_seq=ent_seq;
	}
	public String getUnicode() {
		return this.unicode;
	}
	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
	public String getEntSeq() {
		return this.ent_seq;
	}
	public void setEntSeq(String entSeq) {
		this.ent_seq = entSeq;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UnicodePK)) {
			return false;
		}
		UnicodePK castOther = (UnicodePK)other;
		return 
			this.unicode.equals(castOther.unicode)
			&& this.ent_seq.equals(castOther.ent_seq);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.unicode.hashCode();
		hash = hash * prime + this.ent_seq.hashCode();
		
		return hash;
	}
	public String getEnt_seq() {
		return ent_seq;
	}
	public void setEnt_seq(String ent_seq) {
		this.ent_seq = ent_seq;
	}
}