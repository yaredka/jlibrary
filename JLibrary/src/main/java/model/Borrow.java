package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the borrow database table.
 * 
 */
@Entity
@NamedQuery(name="Borrow.findAll", query="SELECT b FROM Borrow b")
public class Borrow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="act_date_returned")
	private Timestamp actDateReturned;

	@Column(name="borrow_date")
	private Timestamp borrowDate;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;

	//bi-directional many-to-one association to Media
	@ManyToOne
	@JoinColumn(name="media_id")
	private Media media;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="user_id")
	private Member member;

	public Borrow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getActDateReturned() {
		return this.actDateReturned;
	}

	public void setActDateReturned(Timestamp actDateReturned) {
		this.actDateReturned = actDateReturned;
	}

	public Timestamp getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}