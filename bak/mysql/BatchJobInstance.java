package com.david.entity.mysql;
// Generated 2018-5-28 23:25:24 by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * BatchJobInstance generated by hbm2java
 */
@Entity
@Table(name = "batch_job_instance", catalog = "boot", uniqueConstraints = @UniqueConstraint(columnNames = { "JOB_NAME",
		"JOB_KEY" }))
public class BatchJobInstance implements java.io.Serializable {

	private long jobInstanceId;
	private Long version;
	private String jobName;
	private String jobKey;
	private Set batchJobExecutions = new HashSet(0);

	public BatchJobInstance() {
	}

	public BatchJobInstance(long jobInstanceId, String jobName, String jobKey) {
		this.jobInstanceId = jobInstanceId;
		this.jobName = jobName;
		this.jobKey = jobKey;
	}

	public BatchJobInstance(long jobInstanceId, String jobName, String jobKey, Set batchJobExecutions) {
		this.jobInstanceId = jobInstanceId;
		this.jobName = jobName;
		this.jobKey = jobKey;
		this.batchJobExecutions = batchJobExecutions;
	}

	@Id

	@Column(name = "JOB_INSTANCE_ID", unique = true, nullable = false)
	public long getJobInstanceId() {
		return this.jobInstanceId;
	}

	public void setJobInstanceId(long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	@Version
	@Column(name = "VERSION")
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "JOB_NAME", nullable = false, length = 100)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(name = "JOB_KEY", nullable = false, length = 32)
	public String getJobKey() {
		return this.jobKey;
	}

	public void setJobKey(String jobKey) {
		this.jobKey = jobKey;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batchJobInstance")
	public Set getBatchJobExecutions() {
		return this.batchJobExecutions;
	}

	public void setBatchJobExecutions(Set batchJobExecutions) {
		this.batchJobExecutions = batchJobExecutions;
	}

}
