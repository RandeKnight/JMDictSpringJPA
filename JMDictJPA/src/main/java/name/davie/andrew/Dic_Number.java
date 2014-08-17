package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DIC_NUMBER database table.
 * 
 */
@Embeddable
//@Table(name="DIC_NUMBER")
//@NamedQuery(name="Audit.findAll", query="SELECT a FROM Audit a")
public class Dic_Number implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	@Column(name="unicode", length=5)
	private String unicode;

	@Column(name="DR_TYPE", length=30)
	private String dr_type;

	@Column(name="M_VOL", length=6)
	private String m_vol;
	
	@Column(name="M_PAGE", length=6)
	private String m_page;
	
	@Column(name="VALUE", length=20)
	private String value;

	//bi-directional many-to-one association to Character
	@ManyToOne
	@JoinColumn(name="KCHAR")
	private Character kchar;

	public Dic_Number() {
	}

	public String getUnicode() {
		return unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}

	public String getDr_type() {
		return dr_type;
	}

	public void setDr_type(String dr_type) {
		this.dr_type = dr_type;
	}

	public String getM_vol() {
		return m_vol;
	}

	public void setM_vol(String m_vol) {
		this.m_vol = m_vol;
	}

	public String getM_page() {
		return m_page;
	}

	public void setM_page(String m_page) {
		this.m_page = m_page;
	}

	public Character getKchar() {
		return kchar;
	}

	public void setKchar(Character kchar) {
		this.kchar = kchar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}