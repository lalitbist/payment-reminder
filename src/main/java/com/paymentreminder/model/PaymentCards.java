package com.paymentreminder.model;

import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author lalit_bist
 *
 */
@Entity
@Table(name = "payment_cards", catalog = "payment_assitant_db", uniqueConstraints = @UniqueConstraint(columnNames = "card_name"))
public class PaymentCards implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1069071200558416593L;
	private Integer id;
	private User user;
	private String companyName;
	private String cardName;
	private BigDecimal balance;
	private BigDecimal minimumDueAmount;
	private Date paymentDueDate;
	private BigDecimal actualPaidAmount;
	private String paymentSchedule;
	private String accountType;
	private String actualPaymentDate;

	public PaymentCards() {
	}

	public PaymentCards(User user, String cardName,
			BigDecimal minimumDueAmount, Date paymentDueDate,
			BigDecimal actualPaidAmount, String paymentSchedule) {
		this.user = user;
		this.cardName = cardName;
		this.minimumDueAmount = minimumDueAmount;
		this.paymentDueDate = paymentDueDate;
		this.actualPaidAmount = actualPaidAmount;
		this.paymentSchedule = paymentSchedule;
	}

	public PaymentCards(User user, String companyName, String cardName,
			BigDecimal balance, BigDecimal minimumDueAmount,
			Date paymentDueDate, BigDecimal actualPaidAmount,
			String paymentSchedule, String accountType, String actualPaymentDate) {
		this.user = user;
		this.companyName = companyName;
		this.cardName = cardName;
		this.balance = balance;
		this.minimumDueAmount = minimumDueAmount;
		this.paymentDueDate = paymentDueDate;
		this.actualPaidAmount = actualPaidAmount;
		this.paymentSchedule = paymentSchedule;
		this.accountType = accountType;
		this.actualPaymentDate = actualPaymentDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "company_name", length = 45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "card_name", unique = true, nullable = false, length = 45)
	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Column(name = "Balance", precision = 10)
	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name = "minimum_due_amount", nullable = false, precision = 10)
	public BigDecimal getMinimumDueAmount() {
		return this.minimumDueAmount;
	}

	public void setMinimumDueAmount(BigDecimal minimumDueAmount) {
		this.minimumDueAmount = minimumDueAmount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_due_date", nullable = false, length = 19)
	public Date getPaymentDueDate() {
		return this.paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	@Column(name = "actual_paid_amount", nullable = false, precision = 10)
	public BigDecimal getActualPaidAmount() {
		return this.actualPaidAmount;
	}

	public void setActualPaidAmount(BigDecimal actualPaidAmount) {
		this.actualPaidAmount = actualPaidAmount;
	}

	@Column(name = "payment_schedule", nullable = false, length = 5)
	public String getPaymentSchedule() {
		return this.paymentSchedule;
	}

	public void setPaymentSchedule(String paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	@Column(name = "account_type", length = 45)
	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "actual_payment_date", length = 45)
	public String getActualPaymentDate() {
		return this.actualPaymentDate;
	}

	public void setActualPaymentDate(String actualPaymentDate) {
		this.actualPaymentDate = actualPaymentDate;
	}

}
