package com.cognizant.LearnTodayRESTAPI.dao.impl;

import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;
@Repository
public class TrainerDaoImpl implements com.cognizant.LearnTodayRESTAPI.dao.TrainerDao {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rest");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@54");
		return dataSource;
	}

	JdbcTemplate template = new JdbcTemplate(dataSource());
	
	@Override
	public int signUp(Trainer trainer) throws DuplicateKeyException {
		String sql = "insert into trainer values (?,?)";
		int inserted = template.update(sql, trainer.getTrainerId(), trainer.getPassword());
		return inserted;
	}

	@Override
	public int updatePassWord(int trainerId, Trainer trainer) throws InvalidTrainerIdException {
		String sql = "update trainer set password=? where TrainerId=?";
		int updated= template.update(sql, trainer.getPassword(), trainerId);
		if(updated==0)
			throw new InvalidTrainerIdException("Searched data Id not found");
		return updated;
	}

}
