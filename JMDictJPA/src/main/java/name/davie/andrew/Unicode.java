package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UNICODE database table.
 * 
 */
@Entity
@Table(name="UNICODE")
@NamedQuery(name="Unicode.findAll", query="SELECT u FROM Unicode u")
public class Unicode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UnicodePK id;

	@Column(name="LITERAL")
	private String literal;

	//bi-directional many-to-one association to Entry
	@ManyToOne
	@JoinColumn(name="ENTRY_ENT_SEQ")
	private Entry entry;

	public Unicode() {
	}
	public Unicode(String unicode, Long ent_seq) {
		this.id = new UnicodePK(unicode, Long.toString(ent_seq));
	}

	public UnicodePK getId() {
		return this.id;
	}

	public void setId(UnicodePK id) {
		this.id = id;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

}