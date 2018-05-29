package com.david.entity.mysql;
// Generated 2018-5-28 23:25:24 by Hibernate Tools 5.1.7.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * BatchJobSeq generated by hbm2java
 */
@Entity
@Table(name = "batch_job_seq", catalog = "boot", uniqueConstraints = @UniqueConstraint(columnNames = "UNIQUE_KEY"))
public class BatchJobSeq implements java.io.Serializable {

	private BatchJobSeqId id;

	public BatchJobSeq() {
	}

	public BatchJobSeq(BatchJobSeqId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false)),
			@AttributeOverride(name = "uniqueKey", column = @Column(name = "UNIQUE_KEY", unique = true, nullable = false, length = 1)) })
	public BatchJobSeqId getId() {
		return this.id;
	}

	public void setId(BatchJobSeqId id) {
		this.id = id;
	}

}