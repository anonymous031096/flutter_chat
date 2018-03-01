package org.duc.conceptualbank.entity;
// Generated Feb 7, 2018 5:37:51 PM by Hibernate Tools 5.2.8.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Accounts generated by hbm2java
 */
@Entity
@Table(name = "accounts", catalog = "conceptual_bank")
@Proxy(lazy = false)
public class Accounts implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer accountNr;
	private AccountType accountType;
	private Branches branches;
	private Set<Customers> customerses = new HashSet<Customers>(0);

	public Accounts() {
	}

	public Accounts(AccountType accountType, Branches branches) {
		this.accountType = accountType;
		this.branches = branches;
	}

	public Accounts(AccountType accountType, Branches branches, Set<Customers> customerses) {
		this.accountType = accountType;
		this.branches = branches;
		this.customerses = customerses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "account_nr", unique = true, nullable = false)
	public Integer getAccountNr() {
		return this.accountNr;
	}

	public void setAccountNr(Integer accountNr) {
		this.accountNr = accountNr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_type_code", nullable = false)
	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_code", nullable = false)
	public Branches getBranches() {
		return this.branches;
	}

	public void setBranches(Branches branches) {
		this.branches = branches;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "accountses", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonIgnore
	public Set<Customers> getCustomerses() {
		return this.customerses;
	}

	public void setCustomerses(Set<Customers> customerses) {
		this.customerses = customerses;
	}

	public String toString() {
		return "Account: " + accountNr + "\tAccount type code: " + accountType.getAccountTypeCode() + "\tBranch code: "
				+ branches.getBranchCode();
	}
}
