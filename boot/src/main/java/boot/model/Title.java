package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="titles")
public class Title implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)@Column(name="emp_no")
	private int empNo;
	@Column(length=45)
	private String title;
	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	public Title(String title, Date fromDate, Date toDate) {
		super();
		this.title = title;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Title(){
		this("", new Date(),new Date());
	}
	

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Title [empNo=" + empNo + ", title=" + title + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
}
