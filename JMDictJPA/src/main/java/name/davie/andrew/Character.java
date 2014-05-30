package name.davie.andrew;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Characters database table.
 * 
 */
@Entity
@Table(name="Characters")
@NamedQuery(name="Character.findAll", query="SELECT c FROM Character c")
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UNICODE")
	private String unicode;

	@Column(name="CP_TYPE_JIS208")
	private String cpTypeJis208;

	@Column(name="CP_TYPE_UCS")
	private String cpTypeUcs;

	@Lob
	@Column(name="DIC_NUMBERS")
	private byte[] dicNumbers;

	@Column(name="FREQ")
	private int freq;

	@Column(name="GRADE")
	private int grade;

	@Column(name="JA_KUN")
	private String jaKun;

	@Column(name="JA_ON")
	private String jaOn;

	@Column(name="JLPT")
	private int jlpt;

	@Column(name="LITERAL")
	private String literal;

	@Column(name="MEANING")
	private String meaning;

	@Column(name="NANORI")
	private String nanori;

	@Column(name="QUERY_CODE_DEROO")
	private String queryCodeDeroo;

	@Column(name="QUERY_CODE_FOUR_CORNER")
	private String queryCodeFourCorner;

	@Column(name="QUERY_CODE_SH_DESC")
	private String queryCodeShDesc;

	@Column(name="QUERY_CODE_SKIP")
	private String queryCodeSkip;

	@Column(name="RADICAL_CLASSICAL")
	private int radicalClassical;

	@Column(name="RADICAL_NELSON")
	private int radicalNelson;

	@Column(name="STROKE_COUNT")
	private int strokeCount;

	public Character() {
	}

	public String getUnicode() {
		return this.unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}

	public String getCpTypeJis208() {
		return this.cpTypeJis208;
	}

	public void setCpTypeJis208(String cpTypeJis208) {
		this.cpTypeJis208 = cpTypeJis208;
	}

	public String getCpTypeUcs() {
		return this.cpTypeUcs;
	}

	public void setCpTypeUcs(String cpTypeUcs) {
		this.cpTypeUcs = cpTypeUcs;
	}

	public byte[] getDicNumbers() {
		return this.dicNumbers;
	}

	public void setDicNumbers(byte[] dicNumbers) {
		this.dicNumbers = dicNumbers;
	}

	public int getFreq() {
		return this.freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getJaKun() {
		return this.jaKun;
	}

	public void setJaKun(String jaKun) {
		this.jaKun = jaKun;
	}

	public String getJaOn() {
		return this.jaOn;
	}

	public void setJaOn(String jaOn) {
		this.jaOn = jaOn;
	}

	public int getJlpt() {
		return this.jlpt;
	}

	public void setJlpt(int jlpt) {
		this.jlpt = jlpt;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getNanori() {
		return this.nanori;
	}

	public void setNanori(String nanori) {
		this.nanori = nanori;
	}

	public String getQueryCodeDeroo() {
		return this.queryCodeDeroo;
	}

	public void setQueryCodeDeroo(String queryCodeDeroo) {
		this.queryCodeDeroo = queryCodeDeroo;
	}

	public String getQueryCodeFourCorner() {
		return this.queryCodeFourCorner;
	}

	public void setQueryCodeFourCorner(String queryCodeFourCorner) {
		this.queryCodeFourCorner = queryCodeFourCorner;
	}

	public String getQueryCodeShDesc() {
		return this.queryCodeShDesc;
	}

	public void setQueryCodeShDesc(String queryCodeShDesc) {
		this.queryCodeShDesc = queryCodeShDesc;
	}

	public String getQueryCodeSkip() {
		return this.queryCodeSkip;
	}

	public void setQueryCodeSkip(String queryCodeSkip) {
		this.queryCodeSkip = queryCodeSkip;
	}

	public int getRadicalClassical() {
		return this.radicalClassical;
	}

	public void setRadicalClassical(int radicalClassical) {
		this.radicalClassical = radicalClassical;
	}

	public int getRadicalNelson() {
		return this.radicalNelson;
	}

	public void setRadicalNelson(int radicalNelson) {
		this.radicalNelson = radicalNelson;
	}

	public int getStrokeCount() {
		return this.strokeCount;
	}

	public void setStrokeCount(int strokeCount) {
		this.strokeCount = strokeCount;
	}

}