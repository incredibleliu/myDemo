package com.david.entity.h2;
// Generated 2018-5-29 1:37:44 by Hibernate Tools 5.3.0.Beta2

/**
 * BatchJobExecutionParams generated by hbm2java
 */
public class BatchJobExecutionParams implements java.io.Serializable {

	private BatchJobExecutionParamsId id;
	private BatchJobExecution batchJobExecution;

	public BatchJobExecutionParams() {
	}

	public BatchJobExecutionParams(BatchJobExecutionParamsId id, BatchJobExecution batchJobExecution) {
		this.id = id;
		this.batchJobExecution = batchJobExecution;
	}

	public BatchJobExecutionParamsId getId() {
		return this.id;
	}

	public void setId(BatchJobExecutionParamsId id) {
		this.id = id;
	}

	public BatchJobExecution getBatchJobExecution() {
		return this.batchJobExecution;
	}

	public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
		this.batchJobExecution = batchJobExecution;
	}

}
