package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AUDIT database table.
 * 
 */
@Entity
@Table(name="AUDIT")
@NamedQuery(name="Audit.findAll", query="SELECT a FROM Audit a")
public class Audit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="UPD_DATE")
	private Date updDate;

	@Column(name="UPD_DETL")
	private String updDetl;

	//bi-directional many-to-one association to Entry
	@ManyToOne
	@JoinColumn(name="ENTRY_ENT_SEQ")
	private Entry entry;

	public Audit() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUpdDetl() {
		return this.updDetl;
	}

	public void setUpdDetl(String updDetl) {
		this.updDetl = updDetl;
	}

	public Entry getEntry() {
		return this.entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

}