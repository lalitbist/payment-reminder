package com.paymentreminder.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author lalit_bist
 *
 */
@Entity
@Table(name = "reminder", catalog = "payment_assitant_db")
public class Reminder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2171386745391620420L;
	private Integer reminderId;
	private UserModel user;
	private String reminderOptions;
	private String pollScheduler;
	private Date lastPollDate;

	public Reminder() {
	}

	public Reminder(UserModel user, String reminderOptions, String pollScheduler,
			Date lastPollDate) {
		this.user = user;
		this.reminderOptions = reminderOptions;
		this.pollScheduler = pollScheduler;
		this.lastPollDate = lastPollDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reminder_id", unique = true, nullable = false)
	public Integer getReminderId() {
		return this.reminderId;
	}

	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UserModel getUser() {
		return this.user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Column(name = "reminder_options", length = 45)
	public String getReminderOptions() {
		return this.reminderOptions;
	}

	public void setReminderOptions(String reminderOptions) {
		this.reminderOptions = reminderOptions;
	}

	@Column(name = "poll_scheduler", length = 45)
	public String getPollScheduler() {
		return this.pollScheduler;
	}

	public void setPollScheduler(String pollScheduler) {
		this.pollScheduler = pollScheduler;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_poll_date", length = 19)
	public Date getLastPollDate() {
		return this.lastPollDate;
	}

	public void setLastPollDate(Date lastPollDate) {
		this.lastPollDate = lastPollDate;
	}

}
