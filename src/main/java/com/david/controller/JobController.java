package com.david.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.entity.h2.BatchJobInstance;
import com.david.manager.JobInstanceManager;

@RestController
public class JobController {
	
	@Autowired
	private JobInstanceManager jobInstanceManager;
	
	@GetMapping("/job")
	public JobInstanceVo getJobs(){
		BatchJobInstance bji = jobInstanceManager.readRecord((long) 1);
		JobInstanceVo ji = new JobInstanceVo();
		ji.setJobName(bji.getJobName());
		ji.setJobKey(bji.getJobKey());
		ji.setVersion(bji.getVersion());
 		return ji;
	}
	
	public class JobInstanceVo{
		
		private Long version;
		private String jobName;
		private String jobKey;
		
		public Long getVersion() {
			return version;
		}
		public void setVersion(Long version) {
			this.version = version;
		}
		public String getJobName() {
			return jobName;
		}
		public void setJobName(String jobName) {
			this.jobName = jobName;
		}
		public String getJobKey() {
			return jobKey;
		}
		public void setJobKey(String jobKey) {
			this.jobKey = jobKey;
		}
		
	}

}
