package com.piggymumu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.piggymumu.connectoracle.SqlMapper001;
import com.piggymumu.dbdto.JobsResultDto;
import com.piggymumu.form.JobsResultBean;

@Component
public class ConnectDbService {

	@Autowired
	private SqlMapper001 sqlMap;

	public List<JobsResultBean> getTableJobs01(String word) {
		List<JobsResultBean> beanList = new ArrayList<JobsResultBean>();

		List<JobsResultDto> outputlist = sqlMap.JOBS001(word);

		beanList = outputlist.stream().map(this::DtoToBean).collect(Collectors.toList());
		return beanList;
	}

	private JobsResultBean DtoToBean (JobsResultDto dto){

		JobsResultBean bean = new JobsResultBean();
		BeanUtils.copyProperties(dto, bean);
		return bean;
	}
}
